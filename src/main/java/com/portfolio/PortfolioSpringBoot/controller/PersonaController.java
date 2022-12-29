package com.portfolio.PortfolioSpringBoot.controller;

import com.portfolio.PortfolioSpringBoot.model.Persona;
import com.portfolio.PortfolioSpringBoot.service.IPersonaService;
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
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/list")
    @ResponseBody
    public List<Persona> verPersonas() {
       return persoServ.verPersonas();
    }
        
    @PostMapping ("/new")
    public void agregarPersona (@RequestBody Persona pers) {
       persoServ.crearPersona(pers);
    }
    
    @PutMapping ("/update/{id}")
    public void actualizarPersona (@RequestBody Persona pers) {
        persoServ.actualizarPersona(pers);
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
}
