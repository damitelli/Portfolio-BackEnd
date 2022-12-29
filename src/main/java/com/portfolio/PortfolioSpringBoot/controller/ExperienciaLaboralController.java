package com.portfolio.PortfolioSpringBoot.controller;

import com.portfolio.PortfolioSpringBoot.model.ExperienciaLaboral;
import com.portfolio.PortfolioSpringBoot.service.IExperienciaLaboralService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/experiencialaboral")
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService expServ;

    @GetMapping ("/list")
    @ResponseBody
    public List<ExperienciaLaboral> verExperienciaLaboral() {
       return expServ.verExperienciaLaboral();
    }
    
    @PostMapping ("/new")
    public void agregarExperienciaLaboral (@RequestBody ExperienciaLaboral exp) {
       expServ.crearExperienciaLaboral(exp);
    }
    
    @PutMapping ("/update/{id}")
    public void actualizarExperienciaLaboral (@RequestBody ExperienciaLaboral exp) {
        expServ.actualizarExperienciaLaboral(exp);
    }    
    
    @DeleteMapping ("/delete/{id}")
    public void borrarExperienciaLaboral (@PathVariable Long id){
        expServ.borrarExperienciaLaboral(id);
    }

}
