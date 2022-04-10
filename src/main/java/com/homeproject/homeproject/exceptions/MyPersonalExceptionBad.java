package com.homeproject.homeproject.exceptions;

public class MyPersonalExceptionBad extends RuntimeException {
    public MyPersonalExceptionBad(String s) {
        super("Attention exception error on: " + s);
    }


}
