package mindera.mindswap.module2.aop;

import mindera.mindswap.module2.aop.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart shoppingCart= applicationContext.getBean(ShoppingCart.class);
        shoppingCart.checkout();


        shoppingCart.checkout("Cancelled!");



        shoppingCart.quantity();


        try {
            shoppingCart.getError();

        } catch (Exception e) {}

        try {
            shoppingCart.lookingForStuff();
        } catch (InterruptedException e) {}


    }
}