package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "gender")
@Component
public class GenderConfig {

    // This will bind properties like blood.group.A_POSITIVE=A+
    private Map<String, String> list;

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> list) {
        this.list = list;
    }
}
