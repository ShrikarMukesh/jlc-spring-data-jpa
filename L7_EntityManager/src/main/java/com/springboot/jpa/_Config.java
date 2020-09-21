package com.springboot.jpa;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication(scanBasePackages = "com.springboot.jpa")
public class _Config {

	@Bean(name="jlcVendorAdaptor")
	public JpaVendorAdapter hibJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}
	@Bean(name="jlcEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds,
			JpaVendorAdapter jpaVendorAdapter) {

		LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
		emFactory.setDataSource(ds);
		emFactory.setJpaVendorAdapter(jpaVendorAdapter);
		emFactory.setPackagesToScan("com.springboot.jpa");
		return emFactory;

	}
	@Bean(name="jlcTransactionManager")
	public PlatformTransactionManager
	transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		EntityManagerFactory factory = entityManagerFactory.getObject();
		return new JpaTransactionManager(factory);
	}
}
