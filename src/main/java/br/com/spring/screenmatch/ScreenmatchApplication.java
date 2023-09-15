package br.com.spring.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.spring.screenmatch.principal.Principal;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{
//A interface CommandLineRunner permite que executemos alguma ação logo após a inicialização de nossa aplicação.
//Pode ser muito útil, por exemplo, se quisermos carregar alguns dados em nosso banco de dados logo na inicialização de nossa aplicação.


	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}
