package com.zzz.spring_boot_thymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.zzz.spring_boot_thymeleaf.dao")
public class JPAConfig {
	
}
