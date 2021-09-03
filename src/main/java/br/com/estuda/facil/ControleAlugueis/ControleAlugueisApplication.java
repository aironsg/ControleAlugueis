package br.com.estuda.facil.ControleAlugueis;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class ControleAlugueisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleAlugueisApplication.class, args);
	}
	
	
	
	@Bean
	public LocaleResolver localeResolver() {
		//TODO: definindo a linguagem do brasil como padrao
		return  new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
