package br.com.fiap.repository;

import br.com.fiap.beans.CadastroConsultorio;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepository extends JpaRepository<CadastroConsultorio, Long> {
    @Query(value = "CALL INSERIR_ODONTO_CLINICA(:ID_CADASTROCLINICA, :nome, :email, :senha)", nativeQuery = true)
    void cadastrarConsulorio(@Param("ID_CADASTROCLINICA") int ID_CADASTROCLINICA, @Param("nome") String nome, @Param("email") String email, @Param("senha") String senha);

}