package one.traction.aspects;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class EmployeeAspect {
    LocalDateTime start;
    LocalDateTime end;

    @Before("execution(* one.traction.models.EmployeeManager.getAllEmployees(..))")
    public void beforeCreate(JoinPoint joinPoint) {
        start = LocalDateTime.now();
        System.out.println("Before Create: " + joinPoint.getSignature().getName());
    }

    @After("execution(* one.traction.models.EmployeeManager.getAllEmployees(..))")
    public void afterCreate(JoinPoint joinPoint) {
        end = LocalDateTime.now();
        long duration = start.until(end, ChronoUnit.MILLIS);
        System.out.println("After Create: " + joinPoint.getSignature().getName());
        System.out.println("Running time: " + duration);
    }
}
