package com.wrw.MovieRatingFetcher.exceptions;

public class MovieNotFoundException  extends Exception{

  private String message;

  public MovieNotFoundException() {
  }

  public MovieNotFoundException(String message) {
    super(message);
    this.message = message;
  }


}
