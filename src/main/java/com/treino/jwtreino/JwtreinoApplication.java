package com.treino.jwtreino;

import java.util.ArrayList;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.domain.Usuario;
import com.treino.jwtreino.services.UsuarioService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtreinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtreinoApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner initialDb(UsuarioService usuarioService){
	 	return args->{

	 		usuarioService.saveFuncao(new Funcao(null, "QUERY_MANAGER"));
			usuarioService.saveFuncao(new Funcao(null, "DB_ADMIN"));
			usuarioService.saveFuncao(new Funcao(null, "SECURITY_ANALYTIC_CHIEF"));

	 		usuarioService.saveUsuario(new Usuario(null, "Leandro", "leandrinho", "12312", new ArrayList<>()));
			usuarioService.saveUsuario(new Usuario(null, "Bernardo", "bernardopietro", "pitang@0191", new ArrayList<>()));
			usuarioService.saveUsuario(new Usuario(null, "Josué", "josu3@lter", "teslad1Led", new ArrayList<>()));

			usuarioService.addFuncaoToUsuario("leandrinho", "QUERY_MANAGER");
			usuarioService.addFuncaoToUsuario("bernardopietro", "DB_ADMIN");
			usuarioService.addFuncaoToUsuario("josu3@lter", "SECURITY_ANALYTIC_CHIEF");
			usuarioService.addFuncaoToUsuario("josu3@lter", "DB_ADMIN");
	 	};
	 }


}
