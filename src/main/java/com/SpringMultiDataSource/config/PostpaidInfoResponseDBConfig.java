package com.SpringMultiDataSource.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "emfResponse", basePackages = { "com.SpringMultiDataSource.response.repo" })

public class PostpaidInfoResponseDBConfig {
	@Bean(name = "dsResponse")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST=(ADDRESS= (PROTOCOL = TCP)(HOST = 172.21.5.102)(PORT = 1521)) (ADDRESS= (PROTOCOL = TCP)(HOST = 172.21.5.103)(PORT = 1521))(FAILOVER = on)(LOAD_BALANCE = on))(CONNECT_DATA=(SERVICE_NAME = vas)))");
	    dataSource.setUsername("vassdp");
	    dataSource.setPassword("va55dp1");
	    return dataSource;
	}

	@Bean(name = "emfResponse")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dsResponse") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.SpringMultiDataSource.response.domain")
				.persistenceUnit("PostpaidInfoResponse").build();
	}

	@Bean(name = "tmResponse")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("emfResponse") EntityManagerFactory barEntityManagerFactory) {
		return new JpaTransactionManager(barEntityManagerFactory);
	}
}
