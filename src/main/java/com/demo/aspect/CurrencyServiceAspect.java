package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {

    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyServicePointCut() {
    }


    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyServicePointCut() {
    }

    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetAnnotationCurrencyService() {
    }

    @Pointcut("@annotation(com.demo.annotation.InTransaction)")
    public void annotationCurrencyService() {
    }

    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointCut() {
    }

    @Pointcut("args(int,int)")
    public void argsCurrencyServicePointCut() {
    }

    @Pointcut("@args(com.demo.annotation.Validated)")
    public void argsAnnotationCurrencyServicePointCut() {
    }

    //   @Before("withinCurrencyServicePointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );

    }

    // @Before("withinAnnotationCurrencyServicePointCut()")
    public void beforeWithinAnnotation(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );

    }

    // @Before("annotationCurrencyService()")
    public void WithinAnnotation(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );

    }

    //@Before("beanCurrencyServicePointCut()")
    public void beforeBeanCurrency(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );

    }

    //@Before("argsCurrencyServicePointCut()")
    public void argsBeanCurrency(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
    }

    //    @After("targetAnnotationCurrencyService()")
    public void argsAnnotationCurrencyAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );

    }

    // @AfterReturning(value ="argsAnnotationCurrencyServicePointCut()",returning="country")
    public void argsAnnotationAfterReturningCurrencyAdvice(JoinPoint joinPoint, String country) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with before advice. in[%s] after Returning", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );

    }

    //   @AfterThrowing(value ="argsAnnotationCurrencyServicePointCut()",throwing="e")
    public void argsAnnotationAfterThrowingCurrencyAdvice(JoinPoint joinPoint, Throwable e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with After Throwing. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), e.getClass().getName(), LocalDateTime.now())
        );

    }

    @Around("targetAnnotationCurrencyService()")
    public Object argsAnnotationCurrencyAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s '%s is invoked with After Throwing. in[%s]", className, joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), LocalDateTime.now())
        );
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Exception has been Caught");
        } finally {
            System.out.println("After invoking method........");
        }
        return null;
    }
}



