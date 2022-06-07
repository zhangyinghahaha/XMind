package com.nowcoder.community.core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ying.zhang01
 */
public class AlphaAspect {
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("after returning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("after throwing");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("around before");
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("around exception");
        }

        System.out.println("around after");
        return obj;
    }
}
