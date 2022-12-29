package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
    
    public List<ExperienciaLaboral> verExperienciaLaboral();
    
    public void crearExperienciaLaboral(ExperienciaLaboral exp);
    
    public void actualizarExperienciaLaboral(ExperienciaLaboral exp);
    
    public void borrarExperienciaLaboral(Long id);
    
    public ExperienciaLaboral buscarExperienciaLaboral(Long id);
    
}
