package edu.epam.triangle.exception;

public class TriangleReaderException extends Exception {
    public TriangleReaderException() { }

    public TriangleReaderException(String message) {
        super(message);
    }

    public TriangleReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleReaderException(Throwable cause) {
        super(cause);
    }
}
