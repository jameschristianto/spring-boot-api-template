package com.simple.api.enums;

public enum CalculatorEnums {
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private final String message;

    public static final String ADD = "ADD";
    public static final String SUBTRACT = "SUBTRACT";
    public static final String MULTIPLY = "MULTIPLY";
    public static final String DIVIDE = "DIVIDE";

    CalculatorEnums (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
