package br.edu.infnet.CadastroCliente.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.CadastroCliente.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	

}
