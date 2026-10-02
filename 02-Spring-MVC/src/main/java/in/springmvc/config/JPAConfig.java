package in.springmvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "in.springmvc")
@EnableJpaRepositories(basePackages = "in.springmvc.repository")
@EnableTransactionManagement
public class JPAConfig {

    // Database Configuration
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "org.postgresql.Driver"
        );

        dataSource.setUrl(
                "jdbc:postgresql://localhost:5432/springmvc_db"
        );

        dataSource.setUsername("postgres");

        dataSource.setPassword("root");

        return dataSource;
    }

    // JPA and Hibernate Configuration
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource);

        entityManagerFactory.setPackagesToScan(
                "in.springmvc.model"
        );

        entityManagerFactory.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter()
        );

        entityManagerFactory.setEntityManagerFactoryInterface(
                EntityManagerFactory.class
        );

        Properties properties = new Properties();

        properties.setProperty(
                "hibernate.hbm2ddl.auto",
                "update"
        );

        properties.setProperty(
                "hibernate.show_sql",
                "true"
        );

        properties.setProperty(
                "hibernate.format_sql",
                "true"
        );

        entityManagerFactory.setJpaProperties(
                properties
        );

        return entityManagerFactory;
    }

    // Transaction Manager
    @Bean
    public JpaTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(
                entityManagerFactory
        );
    }
}