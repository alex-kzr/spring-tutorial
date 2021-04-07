package com.alexkozyura.tutorial;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.alexkozyura.tutorial")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}
