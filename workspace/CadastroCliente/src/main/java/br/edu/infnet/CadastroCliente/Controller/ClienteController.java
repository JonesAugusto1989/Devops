package br.edu.infnet.CadastroCliente.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.CadastroCliente.Model.Cliente;
import br.edu.infnet.CadastroCliente.Service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/")
	public List<Cliente> findAll(HttpServletRequest request) {
		System.out.println("entrou no controler");
		criaSessao(request);
		List<Cliente> clientListFound = clienteService.findAllCliente();		
		return clientListFound;
	}
	
	@GetMapping("/cria-sessao")
	public String criaSessao(HttpServletRequest request) {
	    request.getSession(true).setAttribute("Sessão", "pt-BR");
	    return "Sessão criada!";
	}

}
