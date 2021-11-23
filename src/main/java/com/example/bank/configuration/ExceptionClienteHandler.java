package com.example.bank.configuration;

import com.example.bank.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionClienteHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ClienteExistenteException.class})
    protected ResponseEntity<Object> usuarioExistente(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Este cliente ya existe",
                new HttpHeaders(), HttpStatus.MULTI_STATUS, request);
    }

    @ExceptionHandler({MenorDeEdadException.class})
    protected ResponseEntity<Object> menorDeEdad(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "El cliente debe tener mas de 18 años",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({TelefonoInvalidoException.class})
    protected ResponseEntity<Object> telefonoInvaido(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "El telefono debe tener 10 digitos",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({CorreoInvalidoException.class})
    protected ResponseEntity<Object> correoInvalido(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "El correo debe contener un @",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ContraLargoInvalidoException.class})
    protected ResponseEntity<Object> contraLargoInvalido(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "La contraseña debe contener 6 digitos como minimo",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ContraSinNumeroException.class})
    protected ResponseEntity<Object> contraSinNumero(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "La contraseña debe contener minimo un numero",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ContraSinAlfaException.class})
    protected ResponseEntity<Object> contraSinAlfa(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "La contraseña debe contener minimo un caracter alfanumerico",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
