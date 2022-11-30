package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountServiceAspect {
    @Pointcut("target(com.demo.service.AccountServiceImpl)")
    public void thisPointcutAccount(){

    }
    @Before("thisPointcutAccount()")
    public void beforeAccountServiceAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked with before advice.",joinPoint.getSignature().getName())
        );
    }
}
