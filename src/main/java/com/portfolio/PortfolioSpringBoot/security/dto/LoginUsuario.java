package com.portfolio.PortfolioSpringBoot.security.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

    @NotBlank(message = "El usuario es requerido.")
    @Length(min = 3)
    private String nombreUsuario;
    @NotBlank(message = "La contraseña es requerida.")
    @Length(min = 6)
    private String password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
