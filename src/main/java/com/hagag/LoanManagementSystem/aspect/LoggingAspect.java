package com.hagag.LoanManagementSystem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Around("execution(* com.hagag.LoanManagementSystem.services..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().toShortString();
        log.info("Entering {}", methodName);

        try {
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - start;
            log.info("Exiting {} after {} ms", methodName, time);
            return result;
        } catch (Exception ex) {
            long time = System.currentTimeMillis() - start;
            log.error("Error in {} after {} ms: {}", methodName, time, ex.getMessage());
            throw ex;
        }
    }
}
