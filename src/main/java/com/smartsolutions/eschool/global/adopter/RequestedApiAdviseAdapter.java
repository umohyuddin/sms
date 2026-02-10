package com.smartsolutions.eschool.global.adopter;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

@Slf4j
@ControllerAdvice

public class RequestedApiAdviseAdapter extends RequestBodyAdviceAdapter {
    @Autowired
    private ObjectMapper objectMapper;

    //Filters: First level of processing, handling cross-cutting concerns like authentication and logging.
    //DispatcherServlet: Central to Spring MVC, dispatches requests to controllers.
    //Handler Mapping: Maps requests to appropriate controller methods.
    //Handler Interceptors: Can be used for pre- and post-processing around handler method execution.
    //RequestBodyAdviceAdapter: Invoked when deserializing the request body, providing hooks before and after reading and deserializing the request body.
    //RequestBodyAdviceAdapter is invoked after the request has passed through the filter chain and before the request body is handed over to the controller method, allowing you to customize the deserialization process of the request body
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        try {
            // Convert request body to JSON string
            String json = objectMapper.writeValueAsString(body);
            log.info("RequestBody [{}]", json);
        } catch (Exception e) {
            log.error("Error converting request body to JSON: {}", e.getMessage());
        }
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
