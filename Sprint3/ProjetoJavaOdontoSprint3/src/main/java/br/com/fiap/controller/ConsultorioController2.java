package br.com.fiap.controller;

import br.com.fiap.beans.CadastroConsultorio;
import br.com.fiap.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController2 {
    @Autowired
    private ConsultorioRepository consultorioRepository;

    @PostMapping
    public ResponseEntity<CadastroConsultorio>
    cadastrarUsuario(@RequestBody CadastroConsultorio consultorio) {
        CadastroConsultorio consultorioSalvo = consultorioRepository.save(consultorio);

        return ResponseEntity.created(URI.create("/clinicas/" + consultorioSalvo.getId())).body(consultorioSalvo);
    }


    @GetMapping("/cadastroConsultorio.html")
    public String mostrarNovaPagina() {
        return "cadastroConsultorio.html";
    }

    @PostMapping("/cadastro-consultorio")
    public String cadastrarConsultorio() {
        return "redirect:/form-consultorio";
    }

    @GetMapping("/form-consultorio")
    public String mostrarFormulario() {
        return "form-consultorio";
    }
}
