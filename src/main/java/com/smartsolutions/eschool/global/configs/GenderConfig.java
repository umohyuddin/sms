package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "gender")
public class GenderConfig {
    private Map<String, String> list;
    public Map<String, String> getList() {
        return list;
    }
    public void setList(Map<String, String> list) {
        this.list = list;
    }
}
