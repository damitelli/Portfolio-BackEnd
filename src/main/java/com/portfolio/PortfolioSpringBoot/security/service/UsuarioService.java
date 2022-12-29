package com.portfolio.PortfolioSpringBoot.security.service;

import com.portfolio.PortfolioSpringBoot.exceptions.AttributeException;
import com.portfolio.PortfolioSpringBoot.security.dto.JwtTokenDto;
import com.portfolio.PortfolioSpringBoot.security.dto.LoginUsuario;
import com.portfolio.PortfolioSpringBoot.security.dto.NuevoUsuario;
import com.portfolio.PortfolioSpringBoot.security.entity.Rol;
import com.portfolio.PortfolioSpringBoot.security.entity.Usuario;
import com.portfolio.PortfolioSpringBoot.security.enums.RolNombre;
import com.portfolio.PortfolioSpringBoot.security.jwt.JwtProvider;
import com.portfolio.PortfolioSpringBoot.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario crearUsuario(NuevoUsuario nuevoUsuario) throws AttributeException {
        if(usuarioRepository.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            throw new AttributeException("El nombre de usuario ya fue registrado.");
        if(usuarioRepository.existsByEmail(nuevoUsuario.getEmail()))
            throw new AttributeException("El email ya fue registrado.");
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }

    public JwtTokenDto iniciarSesion(LoginUsuario loginUsuario){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginUsuario.getNombreUsuario(),
                        loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        return new JwtTokenDto(jwt,userDetails.getUsername(), userDetails.getAuthorities());
    }

}
