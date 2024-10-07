package br.com.fiap.controller;

import br.com.fiap.beans.Cadastro;
import br.com.fiap.beans.Login;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class OdontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontoApplication.class, args);
	}


}
