package br.com.fiap.controller;

import br.com.fiap.beans.CadastroConsultorio;
import br.com.fiap.beans.Clinica;
import br.com.fiap.repository.ConsultorioRepository;
import br.com.fiap.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;

@Controller
public class ControllerFormulario {

    private FormularioRepository formularioRepository;
    @GetMapping("/formulario")
    public ModelAndView index(){
        List<Clinica> clinicas = this.formularioRepository.findAll();
        ModelAndView mv = new ModelAndView("clinicas/index");
        mv.addObject("clinicas", clinicas);
        return mv;
    }
}