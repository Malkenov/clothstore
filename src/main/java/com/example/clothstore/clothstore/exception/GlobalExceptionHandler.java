package com.example.clothstore.clothstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<String> handlerBadRequest(BadRequestException ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handlerNotFound(NotFoundException ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UnprocessableEntityException.class)
  public ResponseEntity<String> handlerUnprocessableEntity(UnprocessableEntityException ex){
    return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
  }


}

