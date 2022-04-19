package com.espada.BS3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Bs3Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs3Application.class, args);
	}

	//Primero se ejecuta primeraClase cuando inicializa el programa
	@PostConstruct
	public void primeraClase(){
		System.out.println("Hola desde clase inicial");
	}

	//Después de iniciar el programa se ejecuta el siguiente Bean
	@Bean
	CommandLineRunner segundaClase(){
		return p ->{
			System.out.println("Hola desde clase secundaria");
		};
	}

	//Por ultimo se ejecuta el siguiente Bean con los argumentos introducidos
	@Bean
	CommandLineRunner terceraClase(ApplicationArguments args){
		return p ->{
			System.out.println("Soy la tercera clase");
			System.out.println("Parametros: "+ Arrays.toString(args.getSourceArgs()));
		};
	}

}
