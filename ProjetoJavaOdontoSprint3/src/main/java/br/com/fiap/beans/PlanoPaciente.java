package br.com.fiap.beans;

import java.util.Date;

public class PlanoPaciente {
    int idPlano, idPaciente, idPlanoPaciente;
    Date dataInicio;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public int getIdPlanoPaciente() {
        return idPlanoPaciente;
    }

    public void setIdPlanoPaciente(int idPlanoPaciente) {
        this.idPlanoPaciente = idPlanoPaciente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    Date dataFim;
}
