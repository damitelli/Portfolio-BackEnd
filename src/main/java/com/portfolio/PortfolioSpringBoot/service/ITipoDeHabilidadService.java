package com.portfolio.PortfolioSpringBoot.service;

import com.portfolio.PortfolioSpringBoot.model.TipoDeHabilidad;
import java.util.List;

public interface ITipoDeHabilidadService {

    public List<TipoDeHabilidad> verTipoDeHabilidades();

    public TipoDeHabilidad buscarTipoDeHabilidades(Long id);

}
