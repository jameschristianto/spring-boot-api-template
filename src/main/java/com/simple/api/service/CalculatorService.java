package com.simple.api.service;

import com.simple.api.dto.CalculatorRequestDTO;
import com.simple.api.entity.CalculatorEntity;
import com.simple.api.enums.CalculatorEnums;
import com.simple.api.repository.CalculatorRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public Integer add(CalculatorRequestDTO dto) {
        return saveLog("ADD", dto.getValue1(), dto.getValue2());
    }

    public Integer subtract(CalculatorRequestDTO dto) {
        return saveLog("SUBTRACT", dto.getValue1(), dto.getValue2());
    }

    public Integer multiply(CalculatorRequestDTO dto) {
        return saveLog("MULTIPLY", dto.getValue1(), dto.getValue2());
    }

    public Integer divide(CalculatorRequestDTO dto) {
        return saveLog("DIVIDE", dto.getValue1(), dto.getValue2());
    }

    private Integer saveLog(String operation, Integer value1, Integer value2) {
        String expression = null;
        Integer result = null;

        try {
            expression = switch (operation) {
                case CalculatorEnums.ADD        -> String.format("%d + %d", value1, value2);
                case CalculatorEnums.SUBTRACT   -> String.format("%d - %d", value1, value2);
                case CalculatorEnums.MULTIPLY   -> String.format("%d * %d", value1, value2);
                case CalculatorEnums.DIVIDE     -> String.format("%d / %d", value1, value2);
                default                         -> null;
            };

            result = switch (operation) {
                case CalculatorEnums.ADD        -> value1 + value2;
                case CalculatorEnums.SUBTRACT   -> value1 - value2;
                case CalculatorEnums.MULTIPLY   -> value1 * value2;
                case CalculatorEnums.DIVIDE     -> value1 / value2;
                default                         -> null;
            };

            CalculatorEntity log = new CalculatorEntity();
            log.setRequestTimestamp(LocalDateTime.now());
            log.setRequestOperation(expression);
            log.setResult(result.toString());
            log.setStatus(CalculatorEnums.SUCCESS.getMessage());
            calculatorRepository.save(log);
        } catch (Exception ex) {
            CalculatorEntity log = new CalculatorEntity();
            log.setRequestTimestamp(LocalDateTime.now());
            log.setRequestOperation(expression);
            log.setResult(null);
            log.setStatus(CalculatorEnums.FAILED.getMessage());
            calculatorRepository.save(log);

            throw ex;
        }

        return result;
    }

    public List<CalculatorEntity> getHistory() {
        return calculatorRepository.findAll();
    }
}
