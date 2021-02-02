package ioc;

import config.CDPlayerConfig;
import config.SoundSystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldBean {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
        CDPlayer cp = context.getBean(CDPlayer.class);
        cp.play();
        System.out.println(cp.getCount());
        CDPlayer cp2 = context.getBean(CDPlayer.class);
        cp2.play();
        System.out.println(cp2.getCount());
        MagicBean mb = context.getBean(MagicBean.class);
    }
}
