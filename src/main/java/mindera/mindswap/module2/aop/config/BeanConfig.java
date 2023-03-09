package mindera.mindswap.module2.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "mindera.mindswap.module2.aop")
@EnableAspectJAutoProxy
public class BeanConfig {
}
