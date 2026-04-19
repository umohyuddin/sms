package com.smartsolutions.eschool.global.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SMS - School Management System API")
                        .version("1.0.0")
                        .description("Comprehensive REST API documentation for the School Management System (SMS). " +
                                "All endpoints require JWT Bearer Authentication unless otherwise specified.")
                        .contact(new Contact()
                                .name("Smart Solutions Support")
                                .email("support@smartsolutions.com")
                                .url("https://smartsolutions.com"))
                        .license(new License()
                                .name("Commercial")
                                .url("https://smartsolutions.com/license")))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.OAUTH2)
                                        .description("Login with your credentials to get a JWT token")
                                        .flows(new OAuthFlows()
                                                .password(new OAuthFlow()
                                                        .tokenUrl("/sms/auth")
                                                        .scopes(new Scopes().addString("global", "access everything"))))));
    }
}
