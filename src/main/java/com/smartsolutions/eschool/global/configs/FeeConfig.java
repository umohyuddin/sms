package com.smartsolutions.eschool.global.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "fee")
@Component
public class FeeConfig {

    private Map<String, String> chargeTypes;
    private Map<String, String> recurrenceRules;

    public Map<String, String> getChargeTypes() {
        return chargeTypes;
    }

    public void setChargeTypes(Map<String, String> chargeTypes) {
        this.chargeTypes = chargeTypes;
    }

    public Map<String, String> getRecurrenceRules() {
        return recurrenceRules;
    }

    public void setRecurrenceRules(Map<String, String> recurrenceRules) {
        this.recurrenceRules = recurrenceRules;
    }
}
