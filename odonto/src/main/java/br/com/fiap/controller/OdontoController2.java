package br.com.fiap.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class OdontoController2 {
	// Conexão tipo GET HTTP
	@RequestMapping("/hello")
	public String index() {
		return "<h1>Olá Mundo!</h1>";
	}

	// Conexão tipo GET HTTP
	@RequestMapping("/cadastro/{nome}")
	public String cadastrarUsuario(@PathVariable String email, @PathVariable String senha) {
		if(email.equals("adm@admin.com") && senha.equals("adm")){
			return "LOGADO";
		} else {
			return "ERRO DE CADASTRO";
		}
	}

	// Conexão tipo GET HTTP
	@RequestMapping("/info")
	public String apresentar(@RequestParam("nome") String nome, @RequestParam("idade") int idade) {
		return "<h1>Olá pessoal, meu nome é " + nome + " e eu tenho " + idade + " anos</h1>";
	}

	// Conexão tipo POST HTTP
	@PostMapping("/postar")
	public String postar() {
		return "Objeto postado com sucesso.";
	}
}
