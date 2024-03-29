package com.milton.auth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
//@EnableResourceServer
public class AuthResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "user-resource";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

//		http.anonymous().disable().authorizeRequests().antMatchers("/users**").authenticated().and().exceptionHandling()
		http.anonymous().disable().authorizeRequests().antMatchers("/client**").permitAll().antMatchers("/users**").authenticated().and().exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());

	}
}
