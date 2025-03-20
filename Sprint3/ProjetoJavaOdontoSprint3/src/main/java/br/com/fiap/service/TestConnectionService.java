package br.com.fiap.service;

import br.com.fiap.repository.TestConnectionRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class TestConnectionService {
    private final DataSource dataSource;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TestConnectionService.class);

    @Autowired
    public TestConnectionService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean verificarConexao() {
        try {
            dataSource.getConnection().close();
            System.out.println("opa2");
            logger.info("✓ Conexão com o banco de dados estabelecida com sucesso");
            return true;
        } catch (SQLException e) {
            logger.info("✗ Falha ao conectar ao banco de dados: {}");
            return false;
        }
    }
}