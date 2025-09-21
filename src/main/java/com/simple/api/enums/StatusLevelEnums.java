package com.simple.api.enums;

public enum StatusLevelEnums {
    SUCCESS("success"),
    INFO("info"),
    WARNING("warning"),
    ERROR("error");

    private final String level;

    StatusLevelEnums(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
