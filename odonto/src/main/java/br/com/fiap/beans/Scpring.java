package br.com.fiap.beans;

import java.util.Date;

public class Scpring {
    int idScoring, scoring, idDentista;

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public int getScoring() {
        return scoring;
    }

    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    public int getIdScoring() {
        return idScoring;
    }

    public void setIdScoring(int idScoring) {
        this.idScoring = idScoring;
    }

    Date dataAvaliacao;
}
