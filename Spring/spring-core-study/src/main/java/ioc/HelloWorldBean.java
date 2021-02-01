package ioc;

import config.CDPlayerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldBean {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CDPlayer cp = context.getBean(CDPlayer.class);
        cp.play();
    }
}
