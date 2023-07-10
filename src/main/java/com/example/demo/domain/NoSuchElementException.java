package com.example.demo.domain;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException() {
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
