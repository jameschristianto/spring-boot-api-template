package com.simple.api.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer add(Integer value1, Integer value2) {
        return value1 + value2;
    }
}
