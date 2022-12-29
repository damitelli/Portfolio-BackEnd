package com.portfolio.PortfolioSpringBoot.security.service;

import com.portfolio.PortfolioSpringBoot.security.entity.Usuario;
import com.portfolio.PortfolioSpringBoot.security.entity.UsuarioPrincipal;
import com.portfolio.PortfolioSpringBoot.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Optional<Usuario> usuario  = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if(!usuario.isPresent())
            throw new UsernameNotFoundException("Usuario o contraseña incorrectos.");
        return UsuarioPrincipal.build(usuario.get());
    }

}
