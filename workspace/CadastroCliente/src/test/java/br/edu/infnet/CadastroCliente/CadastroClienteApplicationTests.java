package br.edu.infnet.CadastroCliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.infnet.CadastroCliente.Controller.ClienteController;
import br.edu.infnet.CadastroCliente.Model.Cliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.mockito.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
@ActiveProfiles("test")

class CadastroClienteApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private ClienteController clienteController;
	private HttpSession session;
	private HttpServletRequest request;
	
    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    void setUp() {
  
   
        cliente1 = new Cliente();
        cliente1.setNome("João da Silva");
        cliente1.setCpfCnpj("12345678901");
        cliente1.setEmail("joao@email.com");
        cliente1.setTelefone("123456789");

        cliente2 = new Cliente();
        cliente2.setNome("Maria Souza");
        cliente2.setCpfCnpj("98765432109");
        cliente2.setEmail("maria@email.com");
        cliente2.setTelefone("987654321");
        
       
    }
    
    @Test
    void incluirCliente() {
    	request = mock(HttpServletRequest.class); 
        session = mock(HttpSession.class);
    	when(request.getSession()).thenReturn(session);
    	when(request.getSession(true)).thenReturn(session);
    	
    	clienteController.incluirCliente(request, cliente1);
    	clienteController.incluirCliente(request, cliente2);
    }

}
