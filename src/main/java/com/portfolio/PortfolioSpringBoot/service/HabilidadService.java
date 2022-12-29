package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.Habilidad;
import com.portfolio.PortfolioSpringBoot.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {
    
    @Autowired
    private HabilidadRepository habRepo;

    @Override
    public List<Habilidad> verHabilidades() {
        return habRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    @Override
    public void actualizarHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habRepo.findById(id).orElse(null);
    }
    
}
