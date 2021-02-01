package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ying.zhang01
 */
@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
public class SoundSystemConfig {
}
