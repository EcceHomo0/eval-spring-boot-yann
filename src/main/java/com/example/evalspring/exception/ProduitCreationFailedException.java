package com.example.evalspring.exception;

public class ProduitCreationFailedException extends RuntimeException{
    public ProduitCreationFailedException(String message) {
        super(message);
    }
}
