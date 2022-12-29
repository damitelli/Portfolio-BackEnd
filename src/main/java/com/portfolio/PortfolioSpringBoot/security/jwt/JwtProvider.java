package com.portfolio.PortfolioSpringBoot.security.jwt;

import com.portfolio.PortfolioSpringBoot.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .signWith(getKey(secret))
                .setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 10))
                .claim("roles", getRoles(usuarioPrincipal))
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey(secret))
                .build().parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(getKey(secret)).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("El token ha expirado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        } catch (SignatureException e) {
            logger.error("Hay un fallo en la firma");
        } catch (IllegalArgumentException e) {
            logger.error("Token vacío");
        }catch (Exception e){
            logger.error("Hay un fallo en el token");
        }
        return false;
    }

    private List<String> getRoles(UsuarioPrincipal usuarioPrincipal) {
        return usuarioPrincipal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    private Key getKey(String secret){
        byte [] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }

}