package com.wp.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wp.models.Emp;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.wp")
public class ProjectConfig {
	
	//Bean for View Resolver.
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setSuffix(".jsp");
		irvr.setPrefix("/pages/");
		return irvr;
	}
	
	//Bean for datasource.
	@Bean
	public ComboPooledDataSource myDataSource(){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("spring2");
		cpds.setPassword("spring2");
		return cpds;
	}
	
	//Bean for sessionFactory.
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(myDataSource());
		
		Class annotatedclass[] = {Emp.class};
		sf.setAnnotatedClasses(annotatedclass);
		
		sf.setPackagesToScan("com.wp");
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		p.setProperty("hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		
		sf.setHibernateProperties(p);
		return sf;
	}
}
