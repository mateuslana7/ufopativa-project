package br.ufop.ufopativa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UfopativaBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UfopativaBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("\nUFOP-ATIVA BACKEND RODANDO...\n");
	}

}
