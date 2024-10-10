package com.lojaAPP.applicationAPI.Config;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Configuration
public class ExceptionHandlerConfig {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFound(){
        return ResponseEntity.status(404).body("Valor não consta na base de dados.");
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<?> handlePersistenceErrors(){
        return ResponseEntity.status(500).body("Não foi possível registrar a entidade, verifique os campos fornecidos.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(){
        return ResponseEntity.status(400).body("Não foi possível realizar o registro, verifique os campos fornecidos.");
    }

}
