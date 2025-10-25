package com.dev.brexchangeapi.exceptions;

public class ErrorConvertingCurrency extends RuntimeException {
  public ErrorConvertingCurrency(String message) {
    super(message);
  }
}
