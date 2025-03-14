package br.com.fiap.controller;

import br.com.fiap.beans.CadastroConsultorio;
import br.com.fiap.service.ConsultorioService;
import br.com.fiap.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class ConsultorioController {
    @Autowired
    private ConsultorioService consultorioService;

    @PostMapping("/cadastrar")
    public String cadastrarConsultorio(@ModelAttribute("consultorioDto") CadastroConsultorio consultorioDto) {
        consultorioService.cadastrarConsultorio(consultorioDto);
        // Redirecionar para uma página de sucesso ou mostrar uma mensagem de sucesso
        return "redirect:/sucesso";
    }
}
