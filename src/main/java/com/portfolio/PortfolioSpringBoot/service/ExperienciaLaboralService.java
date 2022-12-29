package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.ExperienciaLaboral;
import com.portfolio.PortfolioSpringBoot.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired
    public ExperienciaLaboralRepository expRepo;
    
    @Override
    public List<ExperienciaLaboral> verExperienciaLaboral() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperienciaLaboral(ExperienciaLaboral exp) {
        expRepo.save(exp);
    }
    
    @Override
    public void actualizarExperienciaLaboral(ExperienciaLaboral exp) {
        expRepo.save(exp);
    }
 
    @Override
    public void borrarExperienciaLaboral(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public ExperienciaLaboral buscarExperienciaLaboral(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
}
