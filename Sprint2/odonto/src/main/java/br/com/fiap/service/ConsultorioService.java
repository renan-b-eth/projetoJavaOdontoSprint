package br.com.fiap.service;

import br.com.fiap.beans.CadastroConsultorio;
import br.com.fiap.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConsultorioService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void cadastrarConsultorio(CadastroConsultorio consultorioDto) {
        jdbcTemplate.update("CALL INSERIR_ODONTO_CLINICA(?, ?, ?, ?)",
                consultorioDto.getId(),consultorioDto.getNome(), consultorioDto.getEmail(), consultorioDto.getSenha());
    }
}
