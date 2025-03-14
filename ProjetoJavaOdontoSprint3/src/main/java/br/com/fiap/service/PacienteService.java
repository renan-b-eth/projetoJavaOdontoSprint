package br.com.fiap.service;

import br.com.fiap.beans.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
@ComponentScan("br.com.fiap.service")
@Service
public class PacienteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void atualizarPaciente(Long idPaciente, String nome, Date dataNascimento, String sexo, String cpf, String email, String telefone, Long idEndereco) {
        jdbcTemplate.update("call ATUALIZAR_ODONTO_PACIENTE(?, ?, ?, ?, ?, ?, ?, ?)",
                idPaciente, nome, dataNascimento, sexo, cpf, email, telefone, idEndereco);
    }

    public void deletarPaciente(Long idPaciente) {
        jdbcTemplate.update("call DELETAR_ODONTO_PACIENTE(?)", idPaciente);
    }

    public void cadastrarPaciente(Paciente pacienteDTO) {
        jdbcTemplate.update("call INSERIR_ODONTO_PACIENTE(?, ?, ?, ?, ?, ?)",
                pacienteDTO.getNome(),
                pacienteDTO.getDataNascimento(),
                pacienteDTO.getSexo(),
                pacienteDTO.getCpf(),
                pacienteDTO.getEmail(),
                pacienteDTO.getTelefone()
        );
    }

}

