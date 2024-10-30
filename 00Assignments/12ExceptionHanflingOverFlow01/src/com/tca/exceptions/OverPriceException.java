package com.tca.exceptions;

public class OverPriceException extends RuntimeException {
    public OverPriceException(String message) {
        super(message);
    }
}
