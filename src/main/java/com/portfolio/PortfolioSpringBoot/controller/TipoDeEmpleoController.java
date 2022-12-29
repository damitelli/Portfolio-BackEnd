package com.portfolio.PortfolioSpringBoot.controller;

import com.portfolio.PortfolioSpringBoot.model.TipoDeEmpleo;
import com.portfolio.PortfolioSpringBoot.service.ITipoDeEmpleoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/tipoempleo")
public class TipoDeEmpleoController {

    @Autowired
    ITipoDeEmpleoService tipoEmpleoServ;

    @GetMapping("/list")
    public List<TipoDeEmpleo> listaDeTipoEmpleo() {
        return tipoEmpleoServ.verTipoDeEmpleos();
    }

}
