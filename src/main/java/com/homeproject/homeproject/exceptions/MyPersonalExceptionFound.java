package com.homeproject.homeproject.exceptions;

public class MyPersonalExceptionFound extends RuntimeException {
    public MyPersonalExceptionFound(String s) {
        super("Attention exception error at: " + s);
    }
    public MyPersonalExceptionFound() {
        super();
    }

    public MyPersonalExceptionFound(Throwable cause) {
        super(cause);
    }

    public MyPersonalExceptionFound(String s, Throwable cause) {
        super(s, cause);
    }
}
