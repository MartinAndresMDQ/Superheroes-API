package com.mindata.challenge.w2m.superheroes.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomWebRequestInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomWebRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Código que se ejecuta antes de que se maneje la solicitud
        logger.info("Interceptor: PreHandle method executed");
        return true; // Continuar con el procesamiento de la solicitud
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Código que se ejecuta después de que se haya completado la solicitud
        logger.info("Interceptor: AfterCompletion method executed");
    }
}
