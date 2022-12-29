package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List<Proyecto> verProyectos();
    
    public void crearProyecto(Proyecto proy);
    
    public void actualizarProyecto(Proyecto proy);
    
    public void borrarProyecto(Long id);
    
    public Proyecto buscarProyecto(Long id);

}
