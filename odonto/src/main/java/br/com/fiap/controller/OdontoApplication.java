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

	@RequestMapping("/hello")
	public String index() {
		return "<h1>Olá Mundo!</h1>";
	}

	// Conexão tipo GET HTTP
	@RequestMapping("/cadastro/{nome}")
	public String dizernome(@PathVariable String nome) {
		return "Olá, meu nome é " + nome;
	}
	@PostMapping("/cadastrar")
	public String cadastrar(@Validated @RequestBody Cadastro usuarioDto, BindingResult result) {
		if (result.hasErrors()) {
			// Retornar para a página de cadastro com os erros
			return "ERRO";
		}

		Cadastro usuario = new Cadastro();
		BeanUtils.copyProperties(usuarioDto, usuario);
		usuario.setSenha(usuario.getSenha());


		return "cadastro_sucesso";
	}

	@PostMapping("/login")
	public String login(@Validated @RequestBody Login loginDto, BindingResult result) {
		String emailPadrao = "adm@adm.com", senhaPadrao = "adm";
		if (result.hasErrors()) {
			// Retornar para a página de login com os erros
			return "login";
		}

		// Validar o usuário e senha (exemplo simplificado)
		if (emailPadrao.equals(loginDto.getEmail()) || senhaPadrao.equals(loginDto.getSenha())) {

			return "<h1>LOGADO!</h1>";
		}

		// Se a autenticação for válida, redirecionar para outra página
		return "DASHBOARD AQUI";
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
