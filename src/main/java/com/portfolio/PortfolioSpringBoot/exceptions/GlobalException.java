package com.portfolio.PortfolioSpringBoot.exceptions;

import com.portfolio.PortfolioSpringBoot.security.dto.MensajeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MensajeDto> throwAttributeException(AttributeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MensajeDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<MensajeDto> badCredentialsException(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MensajeDto(HttpStatus.NOT_FOUND, "Usuario o contraseña incorrectos."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeDto> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MensajeDto(
                        HttpStatus.BAD_REQUEST, "Los campos no cumplen con la longitud mínima"));
    }

}
