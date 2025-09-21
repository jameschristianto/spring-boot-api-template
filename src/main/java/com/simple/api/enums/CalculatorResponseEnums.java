package com.simple.api.enums;

public enum CalculatorResponseEnums {
    SUCCESS_CALCULATION("S001", "Calculation successful"),
    INVALID_INPUT_TYPE("E001", "Invalid input type: please provide numbers for integer fields"),
    VALUE_REQUIRED("E002", "Value must not be null"),
    INVALID_OPERATION("E003", "Invalid operation");

    private final String code;
    private final String message;

    CalculatorResponseEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}