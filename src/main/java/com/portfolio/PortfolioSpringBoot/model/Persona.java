package com.portfolio.PortfolioSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class Persona {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String nombre;
    private String apellido;
    private String profesion;
    private String localidad;
    private String sobre_mi;
    private String url_foto;
    private String url_portada;  
    
    public Persona(){
    }
    
    public Persona(
            Long id,
            String nombre,
            String apellido,
            String profesion,
            String localidad,
            String sobre_mi,
            String url_foto,
            String url_portada
    ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.localidad = localidad;
        this.sobre_mi = sobre_mi;
        this.url_foto = url_foto;
        this.url_portada = url_portada;
    }
    
}


