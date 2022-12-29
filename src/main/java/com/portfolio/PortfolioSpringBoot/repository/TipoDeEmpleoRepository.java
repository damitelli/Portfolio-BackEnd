package com.portfolio.PortfolioSpringBoot.repository;

import com.portfolio.PortfolioSpringBoot.model.TipoDeEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeEmpleoRepository extends JpaRepository<TipoDeEmpleo, Long> {
}
