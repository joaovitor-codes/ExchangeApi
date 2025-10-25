package com.dev.brexchangeapi.exceptions;

public class ErrorProcessingQuote extends RuntimeException {
  public ErrorProcessingQuote(String message) {
    super(message);
  }
}
