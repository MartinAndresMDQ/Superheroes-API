package com.mindata.challenge.w2m.superheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mindata.challenge.w2m.superheroes.interceptor.CustomWebRequestInterceptor;
import com.mindata.challenge.w2m.superheroes.interceptor.ExecutionTimeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final ExecutionTimeInterceptor executionTimeInterceptor;

    public WebMvcConfig(ExecutionTimeInterceptor executionTimeInterceptor) {
        this.executionTimeInterceptor = executionTimeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executionTimeInterceptor);
    }

    @Bean
    public CustomWebRequestInterceptor customWebRequestInterceptor() {
        return new CustomWebRequestInterceptor();
    }
}
