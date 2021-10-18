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

@SpringBootApplication
public class JwtreinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtreinoApplication.class, args);
	}


	 @Bean
	 CommandLineRunner initialDb(UsuarioService usuarioService){
	 	return args->{
	 		usuarioService.saveFuncao(new Funcao(null, "Quebrador de galho"));
	 		usuarioService.saveUsuario(new Usuario(null, "Leandro", "leandrinho", "12312", new ArrayList<>()));
	 	};
	 }


}
