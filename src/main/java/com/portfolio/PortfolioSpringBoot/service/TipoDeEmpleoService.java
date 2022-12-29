package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.TipoDeEmpleo;
import com.portfolio.PortfolioSpringBoot.repository.TipoDeEmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeEmpleoService implements ITipoDeEmpleoService {

    @Autowired
    public TipoDeEmpleoRepository tipoEmpleoRepo;

    @Override
    public List<TipoDeEmpleo> verTipoDeEmpleos() {
        return tipoEmpleoRepo.findAll();
    }

    @Override
    public TipoDeEmpleo buscarTipoDeEmpleo(Long id) {
        return tipoEmpleoRepo.findById(id).orElse(null);
    }

}
