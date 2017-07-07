package com.actualize.mortgage.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:/srv/actualize-user.properties")
public class UserConfig {

	@Autowired
	Environment env;

	public Environment getEnv() {
		return env;
	}
}
