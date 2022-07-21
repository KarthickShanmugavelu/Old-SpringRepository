package com.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig implements WebMvcConfigurer  {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//define a bean for view resolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver  internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
		
	}
	
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	 }

	//define datasource
	@Bean
	public DataSource securityDataSource() {
		
		//define connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		//log the connection props
		logger.info(">>>>>> jbdc url: "+ env.getProperty("jdbc.url")+"<<<<<<<<<");
		logger.info(">>>>>> jbdc user: "+ env.getProperty("jdbc.user")+"<<<<<<<<<");
		
		//set db conn props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set conn pool props
		securityDataSource.setInitialPoolSize(getPropertyAsInteger("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getPropertyAsInteger("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getPropertyAsInteger("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getPropertyAsInteger("connection.pool.maxIdleTime"));
		
		
		return securityDataSource;
	}
	
	private int getPropertyAsInteger(String propertyName) {
		String propVal = env.getProperty(propertyName);
		return Integer.parseInt(propVal);
	}
	
	
	
}
