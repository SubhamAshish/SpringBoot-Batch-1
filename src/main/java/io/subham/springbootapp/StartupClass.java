package io.subham.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@PropertySource(value = { "classpath:messages.properties" })
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class StartupClass {

	@Autowired
	private ConfigurableEnvironment env;

	public static void main(String[] args) {
		SpringApplication.run(StartupClass.class, args);
	}

	@EventListener
	public void onApplicationStartup(ContextRefreshedEvent e) {
		if (!env.containsProperty("customer.not.found.error")) {
			throw new RuntimeException("customer.not.found.error should be present in application.properties");
		}
	}

}
