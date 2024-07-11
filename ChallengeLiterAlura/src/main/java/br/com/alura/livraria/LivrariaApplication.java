package br.com.alura.livraria;

import br.com.alura.livraria.principal.*;
import br.com.alura.livraria.repository.AutoresRepository;
import br.com.alura.livraria.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {
	@Autowired
	private AutoresRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
