package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.TipoDeEmpleo;
import java.util.List;

public interface ITipoDeEmpleoService {

    public List<TipoDeEmpleo> verTipoDeEmpleos();

    public TipoDeEmpleo buscarTipoDeEmpleo(Long id);

}
