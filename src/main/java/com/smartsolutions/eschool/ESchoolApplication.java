package com.smartsolutions.eschool;

import com.smartsolutions.eschool.global.configs.ReligionConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition()
@EnableJpaAuditing
@EnableConfigurationProperties(ReligionConfig.class)
public class ESchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(ESchoolApplication.class, args);
	}
}
