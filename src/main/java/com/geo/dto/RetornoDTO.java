package com.geo.dto;

public class RetornoDTO {

    private String texto;
    private boolean status;

    public RetornoDTO() {
    }

    public RetornoDTO(String texto, boolean status) {
        this.texto = texto;
        this.status = status;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
