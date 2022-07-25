package com.gcu;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.gcu.interfaces.DataAccessInterface;

@ComponentScan({"com.gcu"})
@EntityScan("com.gcu")
@SpringBootApplication
public class Cst391Milestone2Application {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Cst391Milestone2Application.class, args);
	}
}
