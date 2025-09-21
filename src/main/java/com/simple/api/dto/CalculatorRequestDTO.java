package com.simple.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CalculatorRequestDTO {
    @JsonProperty(value = "value1")
    @Schema(defaultValue = "0")
    @NotNull(message = "cannot be null")
    private Integer value1;

    @JsonProperty(value = "value2")
    @Schema(defaultValue = "0")
    @NotNull(message = "cannot be null")
    private Integer value2;
}
