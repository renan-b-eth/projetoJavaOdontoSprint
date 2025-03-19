package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void executarProcedure(String parametro) {
        jdbcTemplate.execute("CALL minha_procedure(?)");
    }
}
