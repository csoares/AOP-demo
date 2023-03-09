package mindera.mindswap.module2.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* mindera.mindswap.module2.aop.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint joinPoint){
        System.out.println("before logging...");
        System.out.println(joinPoint.getSignature());
        if(joinPoint.getArgs().length>0) {
            System.out.println(joinPoint.getArgs()[0].toString());
        }
    }


    @After("execution(* checkout(..))")
    public void afterLogger(){
        System.out.println("after logging...");
    }



    @AfterReturning(value = "execution(* mindera.mindswap.module2.aop.ShoppingCart.quantity())", returning = "result")

    public void afterReturn(int result){
        System.out.println("After return a value: "+ result);
    }


    @AfterThrowing (pointcut = "execution(* mindera.mindswap.module2.aop.ShoppingCart.*(..))", throwing = "ex")
    public void afterException(Exception ex){
        System.out.println("GET THE EXCEPTION: ex = " + ex);
    }

    @Around("execution(* mindera.mindswap.module2.aop.ShoppingCart.*(..))")
    public void logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }


    @Around("execution(* mindera.mindswap.module2.aop.ShoppingCart.quantity(..))")
    public void logAroundQuantity(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("****LoggingAspect.logAroundQuantity() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("****LoggingAspect.logAroundQuantity() : " + joinPoint.getSignature().getName() + ": After Method Execution");
    }


    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
       // System.out.println("****LoggingAspect.logExecutionTime() : "+joinPoint.getSignature() );

        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("****LoggingAspect.logExecutionTime() : "+joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}
