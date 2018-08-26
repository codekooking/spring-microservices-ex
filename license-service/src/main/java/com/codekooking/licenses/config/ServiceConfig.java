package com.codekooking.licenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

    @Value("${custom.property}")
    private String customProperty;

    public String getCustomProperty() {
        return customProperty;
    }
}
