package mindera.mindswap.module2.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    /*
    within: limits matching to join points within certain types (simply the execution of a method declared within a matching type when using Spring AOP)
    execution:  for matching method execution join points, this is the primary pointcut designator you will use when working with Spring AOP


    In other words, execution matches a method and within matches a type.


    https://www.baeldung.com/spring-aop-pointcut-tutorial
     */

    @Pointcut("execution(* mindera.mindswap.module2.aop.ShoppingCart.checkout(String,..))")
    public void authenticationPointCut(){

    }
    @Pointcut("execution(* mindera.mindswap.module2.aop.ShoppingCart.checkout(String,..))")
//    @Pointcut("within(*..*)")
    public void authorizationPointCut(){

    }

    @Before("authenticationPointCut() && authorizationPointCut() ")
    public void securing(){
        System.out.println("Authenticating the request...");
    }


}
