package com.simple.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class CalculatorConfig {

    private String version = "Calculator API v1.0.0";

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if (version != null && !version.isEmpty()) {
            this.version = version;
        }
    }
}