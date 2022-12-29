package com.portfolio.PortfolioSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Integer porcentaje_de_dominio;
    private Long tipo_de_habilidad_id;

    public Habilidad() {
    }

    public Habilidad(
            Long id,
            String nombre,
            Integer porcentaje_de_dominio,
            Long tipo_de_habilidad_id
    ) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje_de_dominio = porcentaje_de_dominio;
        this.tipo_de_habilidad_id = tipo_de_habilidad_id;
    }

}
