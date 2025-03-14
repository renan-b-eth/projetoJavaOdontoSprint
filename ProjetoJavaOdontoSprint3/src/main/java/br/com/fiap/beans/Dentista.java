package br.com.fiap.beans;

public class Dentista {
    int id;
    int anosExperiencia;
    int taxasSinistro;
    String nome, especialidade, cro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public int getTaxasSinistro() {
        return taxasSinistro;
    }

    public void setTaxasSinistro(int taxasSinistro) {
        this.taxasSinistro = taxasSinistro;
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

}
