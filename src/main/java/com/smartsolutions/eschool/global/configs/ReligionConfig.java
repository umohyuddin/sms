package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "religion")
public class ReligionConfig {

    private Map<String, String> list; // matches the rest of the code

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> religions) {
        this.list = religions;
    }
}

