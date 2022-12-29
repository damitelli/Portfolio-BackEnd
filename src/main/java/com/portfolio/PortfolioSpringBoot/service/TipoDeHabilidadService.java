package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.TipoDeHabilidad;
import com.portfolio.PortfolioSpringBoot.repository.TipoDeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeHabilidadService implements ITipoDeHabilidadService{

    @Autowired
    public TipoDeHabilidadRepository tipoHabilidadRepo;

    @Override
    public List<TipoDeHabilidad> verTipoDeHabilidades() {
        return tipoHabilidadRepo.findAll();
    }

    @Override
    public TipoDeHabilidad buscarTipoDeHabilidades(Long id) {
        return tipoHabilidadRepo.findById(id).orElse(null);
    }

}
