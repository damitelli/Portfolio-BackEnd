package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    
    public List<Habilidad> verHabilidades();
    
    public void crearHabilidad(Habilidad hab);
    
    public void actualizarHabilidad(Habilidad hab);
    
    public void borrarHabilidad(Long id);
    
    public Habilidad buscarHabilidad(Long id);

}
