package com.portfolio.PortfolioSpringBoot.security.jwt;

import com.portfolio.PortfolioSpringBoot.security.dto.MensajeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(
            HttpServletRequest req,
            HttpServletResponse res,
            AuthenticationException e) throws IOException, ServletException {
        logger.error(("Hay un fallo en el método commence."));
        MensajeDto dto = new MensajeDto(
                HttpStatus.UNAUTHORIZED, "No se encontró el token o es invalido");
        res.setContentType("application/json");
        res.setStatus(dto.getStatus().value());
        res.getWriter().write(new ObjectMapper().writeValueAsString(dto));
        res.getWriter().flush();
        res.getWriter().close();
    }

}
