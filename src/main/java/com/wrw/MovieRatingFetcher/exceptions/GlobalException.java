package com.wrw.MovieRatingFetcher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
  @ExceptionHandler(value = MovieNotFoundException.class)
  public ResponseEntity<Object> notFoundException(MovieNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }
}
