package br.com.fiap.controller;

import br.com.fiap.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcedureController {
    @Autowired
    private ProcedureService procedureService;

    @PostMapping("/executar-procedure")
    public String executarProcedure(@RequestParam String parametro) {
        procedureService.executarProcedure(parametro);
        return "redirect:/resultado";
    }
}

// Serviço
