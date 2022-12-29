package com.portfolio.PortfolioSpringBoot.controller;

import com.portfolio.PortfolioSpringBoot.model.Proyecto;
import com.portfolio.PortfolioSpringBoot.service.IProyectoService;
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
@RequestMapping("/proyectos")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proServ;
           
    @GetMapping("/list")
    @ResponseBody
    public List<Proyecto> verProyectos() {
        return proServ.verProyectos();
    }
    
    @PostMapping("/new")
    public void agregarProyecto(@RequestBody Proyecto proy) {
        proServ.crearProyecto(proy);
    }
    
    @PutMapping("/update/{id}")
    public void actualizarProyecto(@RequestBody Proyecto proy) {
        proServ.actualizarProyecto(proy);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proServ.borrarProyecto(id);
    }
    
}
