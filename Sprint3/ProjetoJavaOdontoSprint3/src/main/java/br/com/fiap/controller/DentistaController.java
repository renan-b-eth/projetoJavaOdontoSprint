package br.com.fiap.controller;

import br.com.fiap.beans.Dentista;
import br.com.fiap.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Controller
@Controller
public class DentistaController {
    /*@Autowired*/
    /*private DentistaService service;

    @PostMapping("/inserir-dentista")
    public String inserirDentista(@ModelAttribute Dentista dentista) {
        service.inserirDentista(dentista);
        return "redirect:/lista-dentistas";
    }*/



    @Autowired
    private DentistaService service;

    @GetMapping("/form-dentista")
    public String mostrarFormulario(Model model) {
        model.addAttribute("dentista", new Dentista());
        return "form-dentista";
    }

    @PostMapping("/inserir-dentista")
    public String inserirDentista(@ModelAttribute Dentista dentista) {
        service.inserirDentista(dentista);
        return "redirect:/lista-dentistas";
    }

    @GetMapping("/nova-pagina")
    public String mostrarNovaPagina() {
        return "nova-pagina5587899";
    }


    @Autowired
    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<Dentista> salvar(@RequestBody Dentista dentista) {
        Dentista dentistaSalvo = service.salvarDentista(dentista);
        return ResponseEntity.ok(dentistaSalvo);
    }


}
