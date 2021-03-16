package config;

import aop.Performance;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy
public class AudienceConfig {
}
