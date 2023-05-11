package com.gimeast.memo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class TimeTraceAop {

    private Logger LOGGER = LoggerFactory.getLogger(TimeTraceAop.class);

    @Around("execution(* com.gimeast.memo..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        LOGGER.info("START: " + joinPoint.toString());

        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            LOGGER.info("END: " + joinPoint.toString() + " " + timeMs + "MS");
        }
    }
}
