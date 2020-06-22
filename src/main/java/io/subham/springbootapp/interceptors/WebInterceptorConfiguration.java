package io.subham.springbootapp.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WebInterceptorConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestInterceptors requestInterceptors;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(requestInterceptors);
	}
}
