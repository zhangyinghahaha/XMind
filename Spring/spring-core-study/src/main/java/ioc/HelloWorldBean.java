package ioc;

import config.CDPlayerConfig;
import config.SoundSystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Paths;

public class HelloWorldBean {
    public static void main(String[] args) throws Exception {
        //System.out.println(Paths.get(".").toAbsolutePath());
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
        CDPlayer cp = context.getBean(CDPlayer.class);
        cp.play();
        System.out.println(cp.getCount());
        CDPlayer cp2 = context.getBean(CDPlayer.class);
        cp2.play();
        System.out.println(cp2.getCount());
        MagicBean mb = context.getBean(MagicBean.class);
        StoreService storeService = context.getBean(StoreService.class);
    }
}
