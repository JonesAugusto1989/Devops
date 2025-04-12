#!/bin/bash
set -e

# Verifica se as variáveis estão setadas
if [[ -z "$GH_OWNER" || -z "$GH_REPOSITORY" || -z "$GH_TOKEN" ]]; then
  echo "Variáveis GH_OWNER, GH_REPOSITORY ou GH_TOKEN não foram definidas."
  exit 1
fi

# Gerar nome aleatório para o runner
RUNNER_SUFFIX=$(cat /dev/urandom | tr -dc 'a-z0-9' | fold -w 5 | head -n 1)
RUNNER_NAME="dockerNode-${RUNNER_SUFFIX}"

# Obter token de registro
echo "Requisitando token de registro do GitHub..."
REG_TOKEN=$(curl -sX POST \
  -H "Accept: application/vnd.github.v3+json" \
  -H "Authorization: token ${GH_TOKEN}" \
  https://api.github.com/repos/${GH_OWNER}/${GH_REPOSITORY}/actions/runners/registration-token | jq .token --raw-output)

# Verifica se recebeu um token
if [[ -z "$REG_TOKEN" || "$REG_TOKEN" == "null" ]]; then
  echo "Erro ao obter token de registro. Verifique o GH_TOKEN e as permissões."
  exit 1
fi

# Ir para o diretório do runner
cd /home/docker/actions-runner

# Configurar runner
./config.sh --unattended --url "https://github.com/${GH_OWNER}/${GH_REPOSITORY}" --token "${REG_TOKEN}" --name "${RUNNER_NAME}"

# Definir limpeza no encerramento
cleanup() {
    echo "Removendo runner..."
    ./config.sh remove --unattended --token "${REG_TOKEN}"
}

trap 'cleanup; exit 130' INT
trap 'cleanup; exit 143' TERM

# Iniciar runner
./run.sh & wait $!
