package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastroConsultorio")
    public String novo() {
        return "cadastroConsultorio";
    }
}

