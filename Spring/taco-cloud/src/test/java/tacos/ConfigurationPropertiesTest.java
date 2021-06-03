package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class ConfigurationPropertiesTest {
    @Autowired
    private tacos.config.Test test;

    @Autowired
    private Environment environment;

    @Test
    public void test() {
        this.test.say();

        System.out.println(environment.getDefaultProfiles());
        for (String s : environment.getDefaultProfiles()) {
            System.out.println(s);
        }
        System.out.println(environment.getActiveProfiles());
        for (String s : environment.getActiveProfiles()) {
            System.out.println(s);
        }
        System.out.println(environment.getProperty("spring.application.name"));
    }
}
