package config;

import ioc.CompactDisc;
import ioc.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ying.zhang01
 */
//@Configuration
public class CDConfig {
    //@Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }
}
