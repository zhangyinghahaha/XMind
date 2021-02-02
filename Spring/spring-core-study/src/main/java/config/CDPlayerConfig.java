package config;

import ioc.CDPlayer;
import ioc.CompactDisc;
import ioc.SgtPeppers;
import ioc.SgtPeppers2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
//@ComponentScan("ioc")
public class CDPlayerConfig {
    //@Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
