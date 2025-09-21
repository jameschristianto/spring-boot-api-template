package com.simple.api.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer add(Integer value1, Integer value2) {
        return value1 + value2;
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }
}
