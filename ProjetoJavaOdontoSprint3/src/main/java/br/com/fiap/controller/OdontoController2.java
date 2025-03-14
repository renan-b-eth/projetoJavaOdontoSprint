package br.com.fiap.controller;

import br.com.fiap.beans.Cadastro;
import br.com.fiap.beans.Login;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/odonto")
public class OdontoController2 {

	@Controller
	public class MeuController {
		@GetMapping("/logado")
		public String redirecionar() {
			return "redirect:/dashboard.html";
		}
	}

	@PostMapping("/teste")
	public ResponseEntity<String> myEndpoint(@RequestBody String request) {
		// Processar a requisição
		return ResponseEntity.ok("Requisicao recebida");
	}
	// Conexão tipo GET HTTP
	@GetMapping("/hello")
	public String index() {
		return "<h1>Olá Mundo!</h1>";
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

		return "<h1>cadastro_sucesso</h1>";
	}
	/*METODO DE LOGIN*/
	@GetMapping("/login/{email}/{senha}")
	public String login(@Validated @PathVariable String email, @PathVariable String senha) {
		String emailPadrao = "adm", senhaPadrao = "adm";
		System.out.println(emailPadrao);

		if (emailPadrao.equals(email) && senhaPadrao.equals(senha)) {
			System.out.println("OPA ENTROU");
			return "redirect:/dashboard.html";
		}

		/*if (emailPadrao.equals(loginDto.getEmail()) && senhaPadrao.equals(loginDto.getSenha())) {
			return "redirect:/dashboard.html";
		}*/

		return "<h1 style='color:red;'>LOGIN ERRADO</h1>";
	}
	@PostMapping("/login/{email}/{senha}")
	public String login(@Validated @RequestBody Login loginDto, @PathVariable String email, @PathVariable String senha, BindingResult result) {
		String emailPadrao = "adm", senhaPadrao = "adm";
		if (result.hasErrors()) {
			return "<h1>DEU ERRO</h1>";
		}

		if (emailPadrao.equals(email) && senhaPadrao.equals(senha)) {
			return "redirect:/dashboard";
		}

		return "login";
	}
	// Conexão tipo GET HTTP
	@GetMapping("/info")
	public String apresentar(@RequestParam("nome") String nome, @RequestParam("idade") int idade) {
		return "<h1>Olá pessoal, meu nome é " + nome + " e eu tenho " + idade + " anos</h1>";
	}

	// Conexão tipo POST HTTP
	@PostMapping("/postar")
	public String postar() {
		return "Objeto postado com sucesso.";
	}
}
