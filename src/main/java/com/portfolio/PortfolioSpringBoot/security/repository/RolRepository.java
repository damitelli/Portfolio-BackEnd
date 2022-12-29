package com.portfolio.PortfolioSpringBoot.security.repository;

import com.portfolio.PortfolioSpringBoot.security.entity.Rol;
import com.portfolio.PortfolioSpringBoot.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
