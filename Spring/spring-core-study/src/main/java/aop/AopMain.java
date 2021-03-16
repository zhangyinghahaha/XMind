package aop;

import config.AudienceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AudienceConfig.class);
        Performance performance = applicationContext.getBean(Performance.class);
        performance.perform();
    }
}
