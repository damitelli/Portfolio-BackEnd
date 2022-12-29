package com.portfolio.PortfolioSpringBoot.controller;

import com.portfolio.PortfolioSpringBoot.model.Educacion;
import com.portfolio.PortfolioSpringBoot.service.IEducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @GetMapping ("/list")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return eduServ.verEducacion();
    }
    
    @PostMapping ("/new")
    public void agregarEducacion(@RequestBody Educacion edu) {
        eduServ.crearEducacion(edu);
    }
    
    @PutMapping ("/update/{id}")
    public void actualizarEducacion(@RequestBody Educacion edu) {
        eduServ.actualizarEducacion(edu);
    }
    
    @DeleteMapping ("/delete/{id}") 
    public void borrarEducacion(@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }

}
    

