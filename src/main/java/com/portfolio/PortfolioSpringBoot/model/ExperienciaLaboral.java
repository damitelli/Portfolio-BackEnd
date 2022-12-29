package com.portfolio.PortfolioSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@Entity
public class ExperienciaLaboral {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String puesto;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private String url_logo_empresa;
    private Long tipo_de_empleo_id;
    
    public ExperienciaLaboral(){
    }
    
    public ExperienciaLaboral(
            Long id,
            String puesto,
            String descripcion,
            String fecha_inicio,
            String fecha_fin,
            String url_logo_empresa,
            Long tipo_de_empleo_id
    ){
        this.id = id;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.url_logo_empresa = url_logo_empresa;
        this.tipo_de_empleo_id = tipo_de_empleo_id;
    }
    
}


