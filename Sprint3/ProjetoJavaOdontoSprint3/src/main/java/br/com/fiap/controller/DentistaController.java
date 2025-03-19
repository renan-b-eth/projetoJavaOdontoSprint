package br.com.fiap.controller;

import br.com.fiap.beans.Dentista;
import br.com.fiap.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


}
