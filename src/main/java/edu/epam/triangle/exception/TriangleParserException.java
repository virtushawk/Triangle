package edu.epam.triangle.exception;

public class TriangleParserException extends Exception {
    public TriangleParserException() {
    }

    public TriangleParserException(String message) {
        super(message);
    }

    public TriangleParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleParserException(Throwable cause) {
        super(cause);
    }
}
