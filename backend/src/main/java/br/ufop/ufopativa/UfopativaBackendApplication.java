package br.ufop.ufopativa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.ufopativa.services.PopulateDatabaseService;

@SpringBootApplication
@RestController
public class UfopativaBackendApplication implements CommandLineRunner{
	
	@Autowired
	private PopulateDatabaseService pdbService;

	public static void main(String[] args) {
		SpringApplication.run(UfopativaBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		/**
		 * CHAMADA DO METODO QUE FAZ A LEITURA DOS CURRICULOS EM XML,
		 * MAPEIA OS DADOS PARA A ESTRUTURA DO BANCO E POPULA O MESMO
		 * */
		boolean populateDb = false;
		if(populateDb)	
			pdbService.populate();
		System.out.println("\nUFOP-ATIVA BACKEND RODANDO...\n");
	}

	// @GetMapping("/")
	// public String welcome(){
	// 	return "Bem Vindo ao UFOP Ativa";
	// }

}
