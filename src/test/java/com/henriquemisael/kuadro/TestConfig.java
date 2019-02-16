package com.henriquemisael.kuadro;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("io.ntcg.config")
@EnableAutoConfiguration
@PropertySource("classpath:/application-test.properties")
public class TestConfig {

}
