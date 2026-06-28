package com.example.CRUD.config;

import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalError {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleRuntime(MethodArgumentNotValidException err){
        Map<String, String> dat = new HashMap<>();
        err.getBindingResult().getFieldErrors().stream().forEach(i -> {
            dat.put(i.getField(), i.getDefaultMessage());
        });
        return  ResponseEntity.status(409).body(dat);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleRuntime(Exception err){
        return  ResponseEntity.status(409).body("somthing wend ex; wrong " + err.getMessage().toString() );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException err){
      return  ResponseEntity.status(409).body("somthing wend wrong " + err.getMessage().toString() );
    }
}
