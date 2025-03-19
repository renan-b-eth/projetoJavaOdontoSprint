package br.com.fiap.repository;

import br.com.fiap.beans.Clinica;
import br.com.fiap.beans.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FormularioRepository extends JpaRepository<Clinica, Long> {
    @Query(value = "CALL ODONTO_CADASTROCLINICA(:idclinica, :nome, :email, :senha)", nativeQuery = true)
    void cadastrarClinica(
            @Param("id_cadastroclinica") Integer idclinica,
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("senha") String senha
    );
}