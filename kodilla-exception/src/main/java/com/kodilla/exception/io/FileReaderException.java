package com.kodilla.exception.io;

public class FileReaderException extends Exception {

    // No-argument constructor
    public FileReaderException() {
        super();
    }

    // Constructor with a message
    public FileReaderException(String message) {
        super(message);
    }

    // Constructor with a message and cause (another throwable)
    public FileReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
