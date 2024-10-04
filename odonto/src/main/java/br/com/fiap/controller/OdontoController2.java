package br.com.fiap.controller;

import br.com.fiap.beans.Cadastro;
import br.com.fiap.beans.Login;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class OdontoController2 {
	// Conexão tipo GET HTTP
	@RequestMapping("/hello")
	public String index() {
		return "<h1>Olá Mundo222!</h1>";
	}

	// Conexão tipo GET HTTP
	@PostMapping("/cadastrar")
	public String cadastrar(@Validated @RequestBody Cadastro usuarioDto, BindingResult result) {
		if (result.hasErrors()) {
			// Retornar para a página de cadastro com os erros
			return "ERRO";
		}

		Cadastro usuario = new Cadastro();
		BeanUtils.copyProperties(usuarioDto, usuario);
		usuario.setSenha(usuario.getSenha());
		usuario.setEmail(usuario.getEmail());

		return "cadastro_sucesso";
	}
	@PostMapping("/login")
	public String login(@Validated @RequestBody Login loginDto, BindingResult result) {
		String emailPadrao = "adm@adm.com", senhaPadrao = "adm";
		if (result.hasErrors()) {
			return "<h1>DEU ERRO</h1>";
		}

		if (emailPadrao.equals(loginDto.getEmail()) && senhaPadrao.equals(loginDto.getSenha())) {
			return "redirect:/dashboard";
		}

		return "login";
	}
	@PostMapping("/login/{email}/{senha}")
	public String login(@Validated @RequestBody Login loginDto, @PathVariable String email, @PathVariable String senha, BindingResult result) {
		String emailPadrao = "adm@adm.com", senhaPadrao = "adm";
		if (result.hasErrors()) {
			return "<h1>DEU ERRO</h1>";
		}

		if (emailPadrao.equals(email) && senhaPadrao.equals(senha)) {
			return "redirect:/dashboard";
		}

		return "login";
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
