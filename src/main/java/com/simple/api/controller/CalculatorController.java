package com.simple.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.api.config.CalculatorConfig;
import com.simple.api.dto.CalculatorRequestDTO;
import com.simple.api.dto.CalculatorResponseDTO;
import com.simple.api.enums.CalculatorResponseEnums;
import com.simple.api.enums.StatusLevelEnums;
import com.simple.api.service.CalculatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorConfig calculatorConfig;

    @GetMapping(value = "/info")
    public String version()
    {
        return calculatorConfig.getVersion();
    }

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/addition")
    public ResponseEntity<CalculatorResponseDTO<Integer>> add(@Valid @RequestBody CalculatorRequestDTO calculatorDTO)
    {
        Integer result = calculatorService.add(calculatorDTO.getValue1(), calculatorDTO.getValue2());

        CalculatorResponseDTO<Integer> response = new CalculatorResponseDTO<>(
            StatusLevelEnums.SUCCESS.getLevel(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getCode(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getMessage(),
            result
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculatorResponseDTO<Integer>> subtract(@Valid @RequestBody CalculatorRequestDTO calculatorDTO)
    {
        Integer result = calculatorService.subtract(calculatorDTO.getValue1(), calculatorDTO.getValue2());

        CalculatorResponseDTO<Integer> response = new CalculatorResponseDTO<>(
            StatusLevelEnums.SUCCESS.getLevel(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getCode(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getMessage(),
            result
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculatorResponseDTO<Integer>> multiply(@Valid @RequestBody CalculatorRequestDTO calculatorDTO)
    {
        Integer result = calculatorService.multiply(calculatorDTO.getValue1(), calculatorDTO.getValue2());

        CalculatorResponseDTO<Integer> response = new CalculatorResponseDTO<>(
            StatusLevelEnums.SUCCESS.getLevel(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getCode(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getMessage(),
            result
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculatorResponseDTO<Integer>> divide(@Valid @RequestBody CalculatorRequestDTO calculatorDTO)
    {
        Integer result = calculatorService.divide(calculatorDTO.getValue1(), calculatorDTO.getValue2());

        CalculatorResponseDTO<Integer> response = new CalculatorResponseDTO<>(
            StatusLevelEnums.SUCCESS.getLevel(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getCode(),
            CalculatorResponseEnums.SUCCESS_CALCULATION.getMessage(),
            result
        );

        return ResponseEntity.ok(response);
    }
}