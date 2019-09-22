package com.wp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletMapper extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		//Classes that will be containing configuration.
		
		return new Class[] {ProjectConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		// Url mapping for dispatcher servlet.
		
		return new String[] {"/"};
	}
	
}
