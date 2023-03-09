package mindera.mindswap.module2.aop;

import mindera.mindswap.module2.aop.aspects.LogExecutionTime;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(){
        // Logging
        // Authenticating && Authorization
        // Sanitize data
        // Etc.
        System.out.println("I'm doing the checkout...");
    }


    public void checkout(String status){
        // Logging
        // Authenticating && Authorization
        // Sanitize data
        // Etc.
        System.out.println("I'm doing the checkout..."+ status);
    }


    public Integer quantity(){
        int random_int = (int)Math.floor(Math.random()*(10-1+1)+1);
        System.out.println("random_int = " + random_int);
        return random_int;
    }

    public void getError(){
        throw new RuntimeException("my error in runtime");
    }

    @LogExecutionTime
    public void lookingForStuff() throws InterruptedException {
        System.out.println("Start looking for products...");
        Thread.sleep(2000);
        System.out.println("I found something interesting...");

    }
}
