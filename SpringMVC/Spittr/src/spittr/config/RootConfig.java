package spittr.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import spittr.config.RootConfig.WebPackage;

@Configuration
@ComponentScan( basePackages={"spittr"}, excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {

}
