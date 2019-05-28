package com.wha.hbm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("file:/home/specialjcg/mabase/angular/testibak/TestiBack/src/main/resources/database.properties")
public class DataConfig {

	private final String PROPERTY_DRIVER = "db.driver";
	private final String PROPERTY_URL = "db.url";
	private final String PROPERTY_USERNAME = "db.user";
	private final String PROPERTY_PASSWORD = "db.password";
	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_DIALECT = "hibernate.dialect";
	private final String PROPERTY_HBM2DDL = "hibernate.hbm2ddl.auto";

	@Autowired
	Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.wha.hbm.model" });
		sessionFactory.setHibernateProperties(hibernateProps());
		return sessionFactory;
	}

	Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_HBM2DDL, environment.getProperty(PROPERTY_HBM2DDL));
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
		return properties;
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(environment.getProperty(PROPERTY_URL));
		ds.setUsername(environment.getProperty(PROPERTY_USERNAME));
		ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
		ds.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
		ds.setConnectionProperties(hibernateProps());
		return ds;
	}

	@Bean
	@Autowired
	HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager hibernateTXManager = new HibernateTransactionManager();
		hibernateTXManager.setSessionFactory(s);
		return hibernateTXManager;
	}
}
