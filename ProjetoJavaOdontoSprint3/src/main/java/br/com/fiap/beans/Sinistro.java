package br.com.fiap.beans;

import java.util.Date;

public class Sinistro {
    int idSinistro, idConsulta;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdSinistro() {
        return idSinistro;
    }

    public void setIdSinistro(int idSinistro) {
        this.idSinistro = idSinistro;
    }

    Date data;
    double valor;
    String causa, status;
}
