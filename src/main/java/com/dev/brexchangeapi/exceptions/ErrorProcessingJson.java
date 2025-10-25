package com.dev.brexchangeapi.exceptions;

public class ErrorProcessingJson extends RuntimeException {
  public ErrorProcessingJson(String message) {
    super(message);
  }
}
