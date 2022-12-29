package com.portfolio.PortfolioSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private String url_imagen;
    private String url_proyecto;

    public Proyecto() {
    }

    public Proyecto(
            Long id,
            String nombre,
            String descripcion,
            String fecha_inicio,
            String fecha_fin,
            String url_imagen,
            String url_proyecto
    ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.url_imagen = url_imagen;
        this.url_proyecto = url_proyecto;
    }

}
