package config;

import ioc.BlankDisc;
import ioc.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:app.properties")
public class ExpressiveConfig {
    @Autowired
    Environment env;

    @Bean
    @Primary
    public CompactDisc blanDisc() {
        return new BlankDisc("#{systemProperties['disc.title']}", env.getProperty("disc.artist"));
    }
}
