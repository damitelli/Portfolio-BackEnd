package com.portfolio.PortfolioSpringBoot.security.dto;

import org.springframework.http.HttpStatus;

public class MensajeDto {

    private HttpStatus status;
    private String mensaje;

    public MensajeDto(HttpStatus status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
