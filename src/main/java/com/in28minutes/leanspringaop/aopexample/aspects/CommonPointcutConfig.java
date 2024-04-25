package com.in28minutes.leanspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.in28minutes.leanspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.in28minutes.leanspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.in28minutes.leanspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void dataPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.in28minutes.leanspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
