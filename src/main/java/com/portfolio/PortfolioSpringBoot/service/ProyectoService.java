package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.Proyecto;
import com.portfolio.PortfolioSpringBoot.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    public ProyectoRepository proRep;

    @Override
    public List<Proyecto> verProyectos() {
        return proRep.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proy) {
        proRep.save(proy);
    }

    @Override
    public void actualizarProyecto(Proyecto proy) {
        proRep.save(proy);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRep.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proRep.findById(id).orElse(null);
    }
    
}
