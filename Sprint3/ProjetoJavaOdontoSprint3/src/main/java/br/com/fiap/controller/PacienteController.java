package br.com.fiap.controller;

import br.com.fiap.beans.Paciente;
import br.com.fiap.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pacientes")
@ComponentScan("br.com.fiap.service")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private RestTemplate restTemplate;


    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteDTO) {
        try {
            pacienteService.atualizarPaciente(id, pacienteDTO.getNome(), pacienteDTO.getDataNascimento(),
                    pacienteDTO.getSexo(), pacienteDTO.getCpf(), pacienteDTO.getEmail(),
                    pacienteDTO.getTelefone(), pacienteDTO.getIdEndereco());
            return ResponseEntity.ok("Paciente atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPaciente(@PathVariable Long id) {
        try {
            pacienteService.deletarPaciente(id);
            return ResponseEntity.ok("Paciente deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar paciente: " + e.getMessage());
        }
    }

    @PostMapping("/cadastrarpaciente")
    public String cadastrarPaciente(@ModelAttribute Paciente paciente) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    "http://localhost:8080/pacientes", paciente, String.class);
        } catch (RestClientException e) {
            // Tratar exceções
        }
        return "sucesso";
    }

    @Autowired
    private PacienteService pacienteService2;

    @PostMapping("/cadastrar")
    public String cadastrarPaciente(@Validated @ModelAttribute("pacienteDto") Paciente pacienteDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cadastro"; // redirecionar para a página de cadastro com os erros
        }

        pacienteService2.cadastrarPaciente(pacienteDTO);
        return "redirect:/sucesso"; // redirecionar para a página de sucesso
    }

}