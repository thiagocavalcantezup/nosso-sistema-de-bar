package br.com.zup.edu.nossosistemadebares.bar;

import javax.validation.constraints.NotNull;

public class ReservarMesaRequest {

    @NotNull
    private String reservadoPara;

    public ReservarMesaRequest(String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }

    public ReservarMesaRequest() {}

    public String getReservadoPara() {
        return reservadoPara;
    }

}
