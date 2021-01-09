package com.upfpo.app;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	} 
	 
	 @Bean
	 public DataSource dataSource() 
	 { 
	  DriverManagerDataSource dataSource =   new DriverManagerDataSource();
	  dataSource.setDriverClassName("org.postgresql.Driver");
	  dataSource.setUrl("jdbc:postgresql://localhost:5432/upfpo_db");
	  dataSource.setUsername("postgres"); dataSource.setPassword("postgres");
	  return dataSource; 
	  }
	  
	 
	 @Bean 
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	   { 
		 
	   LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	   em.setDataSource(dataSource());
	   em.setPackagesToScan(new String[] {"com.upfpo"});
	   Properties jpaProperties = new Properties();
       jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-update");
	   HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	   vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
	   em.setJpaVendorAdapter(vendorAdapter);
	   return em; 
	   }
	 
	 @Bean public PersistenceExceptionTranslationPostProcessor
	  exceptionTranslation()
	 { return new
	  PersistenceExceptionTranslationPostProcessor(); }
	  
	/*
	 * @Bean public HibernateTransactionManager transactionManager() {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager();
	 * transactionManager.setSessionFactory((SessionFactory)
	 * entityManagerFactory().getObject()); return transactionManager; }
	 */
	  
}
