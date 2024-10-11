package com.lojaAPP.applicationAPI.Config;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

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
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException exception){
        List<String> exceptionErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ":" + error.getDefaultMessage()).toList();

        return ResponseEntity.status(400).body(exceptionErrors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleIntegrityViolation(){
        return ResponseEntity.status(500).body("Não é possível realizar a exclusão, verifique outras entidades que possuem vínculo a essa.");
    }

}
