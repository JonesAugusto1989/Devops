package br.edu.infnet.CadastroCliente.config;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;

@Configuration
@Profile({"default", "dev"})
public class DevSessionConfig {
	@Bean
	public SessionRepository<?> sessionRepository(){
		return new MapSessionRepository(new ConcurrentHashMap<>());
	}

}
