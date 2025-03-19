package br.com.fiap.beans;

import jakarta.persistence.Id;

import java.math.BigDecimal;

public class Dentista {
    @Id
    private Long idDentista;
    private String nome;
    private String especialidade;
    private String cro;
    private BigDecimal taxaSinistros;
    private Long idEndereco;

    public Long getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Long idDentista) {
        this.idDentista = idDentista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public BigDecimal getTaxaSinistros() {
        return taxaSinistros;
    }

    public void setTaxaSinistros(BigDecimal taxaSinistros) {
        this.taxaSinistros = taxaSinistros;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}
