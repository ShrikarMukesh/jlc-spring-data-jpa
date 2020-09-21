package com.springboot.jpa;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = "com.springboot.jpa")
@EnableAutoConfiguration
public class HibernateConfigClass {

	@Bean(name="jlcDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jlcdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean(name="jlcSessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean lsfatory = new LocalSessionFactoryBean();
		lsfatory.setDataSource(dataSource);
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.transaction.factory_class",
				"org.hibernate.transaction.JDBCTransactionFactory");
		lsfatory.setHibernateProperties(props);
		lsfatory.setPackagesToScan("com.springboot.jpa");
		return lsfatory;
	}

	@Bean(name="jlcHibernateTemplate")
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	@Bean(name="jlcHibernateTransactionManager")
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
