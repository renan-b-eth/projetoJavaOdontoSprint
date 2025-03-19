package br.com.fiap.repository;

import br.com.fiap.beans.CadastroConsultorio;
import br.com.fiap.beans.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query(value = "CALL INSERIR_ODONTO_PACIENTE(:p_id_paciente, :p_nome_paciente, :p_data_nascimento, :p_sexo, :p_cpf, :p_email, :p_historico, :p_frequencia, :p_id_endereco, :p_id_plano)", nativeQuery = true)
    void cadastrarPaciente(
            @Param("p_id_paciente") Integer pIdPaciente,
            @Param("p_nome_paciente") String pNomePaciente,
            @Param("p_data_nascimento") LocalDate pDataNascimento,
            @Param("p_sexo") String pSexo,
            @Param("p_cpf") String pCpf,
            @Param("p_email") String pEmail,
            @Param("p_historico") String pHistorico,
            @Param("p_frequencia") Integer pFrequencia,
            @Param("p_id_endereco") Integer pIdEndereco,
            @Param("p_id_plano") Integer pIdPlano
    );
}