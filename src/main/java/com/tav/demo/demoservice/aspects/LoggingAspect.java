package com.tav.demo.demoservice.aspects;

import com.tav.demo.demoservice.annotations.LogParameters;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(logParametersAnnotation)")
    public void logAdvice(final JoinPoint joinPoint,
                          final LogParameters logParametersAnnotation) {
        final MethodSignature sig = (MethodSignature) joinPoint.getSignature();
        final String[] names = sig.getParameterNames();
        System.out.println(names);
    }
}
