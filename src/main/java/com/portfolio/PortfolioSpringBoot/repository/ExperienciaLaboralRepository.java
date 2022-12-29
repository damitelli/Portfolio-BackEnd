package com.portfolio.PortfolioSpringBoot.repository;

import com.portfolio.PortfolioSpringBoot.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository <ExperienciaLaboral, Long> {
    
}
