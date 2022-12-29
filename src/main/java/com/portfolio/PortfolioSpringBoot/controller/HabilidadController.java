package com.portfolio.PortfolioSpringBoot.controller;

import com.portfolio.PortfolioSpringBoot.model.Habilidad;
import com.portfolio.PortfolioSpringBoot.service.IHabilidadService;
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
@RequestMapping("/habilidades")
public class HabilidadController  {
    
    @Autowired
    private IHabilidadService habServ;
    
    @GetMapping("/list")
    @ResponseBody
    public List<Habilidad> verHabilidades() {
        return habServ.verHabilidades();
    }
    
    @PostMapping ("/new")
    public void agregarHabilidad(@RequestBody Habilidad hab) {
        habServ.crearHabilidad(hab);
    }
    
    @PutMapping("/update/{id}")
    public void actualizarHabilidad(@RequestBody Habilidad hab) {
        habServ.actualizarHabilidad(hab);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarHabilidad(@PathVariable Long id) {
        habServ.borrarHabilidad(id);
    }

}
