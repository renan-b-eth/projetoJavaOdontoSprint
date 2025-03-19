package br.com.fiap.repository;

import br.com.fiap.beans.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
    @Modifying
    @Query(value = "CALL ODONTO_PACKAGE.INSERIR_ODONTO_DENTISTA(:id, :nome, :especialidade, :cro, :taxa, :endereco)",
            nativeQuery = true)
    void inserirDentista(
            @Param("id_dentista") Long id,
            @Param("nome") String nome,
            @Param("especialidade") String especialidade,
            @Param("cro") String cro,
            @Param("taxa") BigDecimal taxa,
            @Param("id_endereco") Long endereco
    );
}