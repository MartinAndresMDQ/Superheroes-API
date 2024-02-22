package com.mindata.challenge.w2m.superheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.mindata.challenge.w2m.superheroes.interceptor.CustomWebRequestInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customWebRequestInterceptor());
    }

    @Bean
    public CustomWebRequestInterceptor customWebRequestInterceptor() {
        return new CustomWebRequestInterceptor();
    }
}
