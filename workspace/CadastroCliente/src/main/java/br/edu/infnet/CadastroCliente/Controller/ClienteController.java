package br.edu.infnet.CadastroCliente.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Cliente>>  findAll(HttpServletRequest request) {
		System.out.println("entrou no controler");
		criaSessao(request);
		List<Cliente> clientListFound = clienteService.findAllCliente();	
		
		return ResponseEntity.ok(clientListFound);
	}
	
	@GetMapping("/cria-sessao")
	public String criaSessao(HttpServletRequest request) {
	    request.getSession(true).setAttribute("Sessão", "pt-BR");
	    return "Sessão criada!";
	}
	
	@PostMapping("/incluircliente")
	public ResponseEntity<String> incluirCliente(HttpServletRequest request,@RequestBody Cliente cliente) {
		criaSessao(request);
		clienteService.saveCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado com sucesso");
	}

}
