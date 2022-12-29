package com.portfolio.PortfolioSpringBoot.repository;

import com.portfolio.PortfolioSpringBoot.model.TipoDeHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeHabilidadRepository extends JpaRepository<TipoDeHabilidad, Long> {
}
