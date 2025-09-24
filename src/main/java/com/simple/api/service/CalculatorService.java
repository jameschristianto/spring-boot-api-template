package com.simple.api.service;

import com.simple.api.dto.CalculatorRequestDTO;
import com.simple.api.entity.CalculatorEntity;
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
        Integer result = null;
        try {
            result = null;
            result = dto.getValue1() + dto.getValue2();
            saveLog(
                "ADD",
                dto.getValue1(),
                dto.getValue2(),
                result.toString(),
                "SUCCESS"
            );
        } catch (Exception ex) {
            saveLog(
                "ADD",
                dto.getValue1(),
                dto.getValue2(),
                null,
                "FAILED"
            );
            throw ex;
        }
        return result;
    }

    public Integer subtract(CalculatorRequestDTO dto) {
        Integer result = null;
        try {
            result = null;
            result = dto.getValue1() - dto.getValue2();
            saveLog(
                "SUBTRACT",
                dto.getValue1(),
                dto.getValue2(),
                result.toString(),
                "SUCCESS"
            );
        } catch (Exception ex) {
            saveLog(
                "SUBTRACT",
                dto.getValue1(),
                dto.getValue2(),
                null,
                "FAILED"
            );
            throw ex;
        }
        return result;
    }

    public Integer multiply(CalculatorRequestDTO dto) {
        Integer result = null;
        try {
            result = null;
            result = dto.getValue1() * dto.getValue2();
            saveLog(
                "MULTIPLY",
                dto.getValue1(),
                dto.getValue2(),
                result.toString(),
                "SUCCESS"
            );
        } catch (Exception ex) {
            saveLog(
                "MULTIPLY",
                dto.getValue1(),
                dto.getValue2(),
                null,
                "FAILED"
            );
            throw ex;
        }
        return result;
    }

    public Integer divide(CalculatorRequestDTO dto) {
        Integer result = null;
        try {
            result = null;
            result = dto.getValue1() / dto.getValue2();
            saveLog(
                "DIVIDE",
                dto.getValue1(),
                dto.getValue2(),
                result.toString(),
                "SUCCESS"
            );
        } catch (Exception ex) {
            saveLog(
                "DIVIDE",
                dto.getValue1(),
                dto.getValue2(),
                null,
                "FAILED"
            );
            throw ex;
        }
        return result;
    }

    private void saveLog(String operation, Integer value1, Integer value2, String result, String status) {
        String expression = switch (operation) {
            case "ADD"      -> String.format("%d + %d", value1, value2);
            case "SUBTRACT" -> String.format("%d - %d", value1, value2);
            case "MULTIPLY" -> String.format("%d * %d", value1, value2);
            case "DIVIDE"   -> String.format("%d / %d", value1, value2);
            default         -> "NOT DEFINED";
        };

        CalculatorEntity log = new CalculatorEntity();
        log.setRequestTimestamp(LocalDateTime.now());
        log.setRequestOperation(expression);
        log.setResult(result);
        log.setStatus(status);
        calculatorRepository.save(log);
    }

    public List<CalculatorEntity> getHistory() {
        return calculatorRepository.findAll();
    }
}
