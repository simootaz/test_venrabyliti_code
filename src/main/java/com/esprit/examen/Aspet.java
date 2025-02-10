package com.esprit.examen;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Aspet {

    @Pointcut("execution(* com.esprit.examen.services.*.add*(..))")
    private void addMethod() {}

    @After("addMethod()")
    public void afterAdding(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("La méthode d'ajout " + methodName + " s'est bien déroulée");

    }
}
