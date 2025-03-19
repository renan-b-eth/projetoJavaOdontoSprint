package com.example.odonto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    // Conexao do tipo GET HTTP
    @RequestMapping("/hello")
    public String index(){return "<h1>Olá Mundo!</h1>";}

    @RequestMapping("/cadastro/{nome}")
    public String dizernome(@PathVariable String nome){return "Olá, meu nome " + nome;}

    @RequestMapping("/info")
    public String apresentar(@RequestParam("Nome") String nome, @RequestParam("idade") int idade) {
        return "<h1>Olá pessoa, meu nome é  " + nome + " e eu tenho " + idade + "anos</h1>";
    }
}
