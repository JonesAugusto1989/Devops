package br.edu.infnet.CadastroCliente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.CadastroCliente.Model.Cliente;
import br.edu.infnet.CadastroCliente.Repository.ClienteRepository;

@Service
public class ClienteService {

	ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Optional<Cliente> findByCpfCnpj(String cpfCnpj) {
		return clienteRepository.findById(cpfCnpj);
	}
	
	public List<Cliente> findAllCliente(){
		System.out.println("entrou no service");
		List<Cliente> clientesFound = clienteRepository.findAll();		
		return clientesFound;
	}
	
	public void deleteCliente(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public Cliente saveCliente(Cliente cliente) {
		
		 Cliente clienteSaved= clienteRepository.save(cliente);
		
		return clienteSaved;
	}
	
	public Cliente updateCliente(Cliente cliente) throws Exception {
		
		if(cliente.getCpfCnpj() == null) {
			throw new Exception("O cliente não pode ser salvo.");
		}
		
		Cliente clienteUpdated = clienteRepository.save(cliente);
		return  clienteUpdated;
	}
	
}
