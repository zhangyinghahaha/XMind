package tacos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "greeting")
public class Test {
    private String welcome = "1";

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public void say () {
        System.out.println("hello, " + this.welcome);
    }
}
