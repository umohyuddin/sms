package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "blood")
@Component
public class BloodGroupConfig {

    // This will bind properties like blood.group.A_POSITIVE=A+
    private Map<String, String> group;

    public Map<String, String> getGroup() {
        return group;
    }

    public void setGroup(Map<String, String> group) {
        this.group = group;
    }
}
