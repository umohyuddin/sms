package com.smartsolutions.eschool.global.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "fee")
public class FeeConfig {

    private Map<String, String> chargeTypes;
    private Map<String, String> recurrenceRules;
    private Map<String, String> discountTypes;

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
    public Map<String, String> getDiscountTypes() {
        return discountTypes;
    }

    public void setDiscountTypes(Map<String, String> discountTypes) {
        this.discountTypes = discountTypes;
    }
}
