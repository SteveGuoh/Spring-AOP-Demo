package com.in28minutes.leanspringaop.aopexample.aspects;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Before("com.in28minutes.leanspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect {} - is called with arguments - {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.in28minutes.leanspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect {} has executed", joinPoint);
    }

    @AfterThrowing( pointcut = "com.in28minutes.leanspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()"
            , throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning( pointcut = "com.in28minutes.leanspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()"
            , returning = "resultValue")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
    }
}
