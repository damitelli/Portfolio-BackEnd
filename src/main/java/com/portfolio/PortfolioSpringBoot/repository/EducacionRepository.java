package com.portfolio.PortfolioSpringBoot.repository;

import com.portfolio.PortfolioSpringBoot.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long>{

}
