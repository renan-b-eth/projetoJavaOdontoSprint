package br.com.fiap.beans;

public class Plano {
    int idPlanoPaciente;

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public int getIdPlanoPaciente() {
        return idPlanoPaciente;
    }

    public void setIdPlanoPaciente(int idPlanoPaciente) {
        this.idPlanoPaciente = idPlanoPaciente;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public double getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(double valorPlano) {
        this.valorPlano = valorPlano;
    }

    String nomePlano, tipoPlano;
    double valorPlano;
}
