package com.example.bank.configuration.profiles;

import com.example.bank.exception.BlockedUser;
import com.example.bank.exception.NonExistentCustomer2Exception;
import com.example.bank.exception.NonExistentCustomerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionCustomerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NonExistentCustomerException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request)
    {
        return handleExceptionInternal(ex, "Ese usuario no existe", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

   @ExceptionHandler({NonExistentCustomer2Exception.class})
    protected ResponseEntity<Object> handleNotContra(Exception ex, WebRequest request)
    {
        return handleExceptionInternal(ex, "La contraseña es incorrecta", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({BlockedUser.class})
    protected ResponseEntity<Object> handleDuplicate(Exception ex, WebRequest request)
    {
        return handleExceptionInternal(ex, "El uasuario esta bloqeuado", new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }
}
