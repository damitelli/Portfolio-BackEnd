package com.portfolio.PortfolioSpringBoot.security.controller;

import com.portfolio.PortfolioSpringBoot.exceptions.AttributeException;
import com.portfolio.PortfolioSpringBoot.security.dto.JwtTokenDto;
import com.portfolio.PortfolioSpringBoot.security.dto.LoginUsuario;
import com.portfolio.PortfolioSpringBoot.security.dto.MensajeDto;
import com.portfolio.PortfolioSpringBoot.security.dto.NuevoUsuario;
import com.portfolio.PortfolioSpringBoot.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/nuevo")
    public ResponseEntity<MensajeDto> nuevo(
            @Valid @RequestBody NuevoUsuario nuevoUsuario
    ) throws AttributeException {
        usuarioService.crearUsuario(nuevoUsuario);
        return ResponseEntity.ok(new MensajeDto(
                HttpStatus.OK,"El usuario " +
                nuevoUsuario.getNombreUsuario() +
                " ha sido creado con éxito."));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody LoginUsuario loginUsuario){
        JwtTokenDto jwtTokenDto = usuarioService.iniciarSesion(loginUsuario);
        return ResponseEntity.ok(jwtTokenDto);
    }

}
