package net.drs.fotoshopbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//database configuration.. 

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages={"net.drs.fotoshopbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	
	// this needs to be read from application yaml or properties
	
	@Value("${spring.datasource.url}")
	private String databaseURL;

	@Value("${spring.datasource.driver-class-name}")
	private String database_Driver;
	
	@Value("${spring.datasource.dialect}")
	private String database_dialect;
	
	@Value("${spring.datasource.username}")
	private String database__username;
	
	@Value("${spring.datasource.password}")
	private String database_password;
	
	
	//private final static String DATABASE_DRIVER="org.h2.Driver";
	//private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	//private final static String DATABASE_USERNAME="fotoshop";
	//private final static String DATABASE_PASSWORD="";
	
	
	
	@Bean("dataSource")
	public DataSource getDatasource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(database_Driver);
		dataSource.setUrl(databaseURL);
		dataSource.setUsername(database__username);
		dataSource.setPassword(database_password);
		
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.addProperties(getHibernateProperties());
		sessionFactoryBuilder.scanPackages("net.drs.fotoshopbackend.dto");
		return sessionFactoryBuilder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", database_dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
	properties.put("hibernate.hbm2ddl.auto", "update");
	//properties.put("hibernate.hbm2ddl.auto", "create");
		
		return properties;
	}
	
	
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}

	
	// getters and setters
	
/*	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}

	public String getDatabase_dialect() {
		return database_dialect;
	}

	public void setDatabase_dialect(String database_dialect) {
		this.database_dialect = database_dialect;
	}

	public String getDatabase__username() {
		return database__username;
	}

	public void setDatabase__username(String database__username) {
		this.database__username = database__username;
	}

	public String getDatabase_password() {
		return database_password;
	}

	public void setDatabase_password(String database_password) {
		this.database_password = database_password;
	}

	public String getDatabase_Driver() {
		return database_Driver;
	}

	public void setDatabase_Driver(String database_Driver) {
		this.database_Driver = database_Driver;
	}

	
*/
}
