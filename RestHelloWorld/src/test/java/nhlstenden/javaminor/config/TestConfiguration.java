package nhlstenden.javaminor.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "nhlstenden.javaminor.resource")
@EnableTransactionManagement
public class TestConfiguration {
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).setName("DB_CLOSE_ON_EXIT=FALSE;MODE=MySQL").build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("nhlstenden.javaminor.resource.model");
        em.setDataSource(dataSource());
        em.setJpaProperties(additionalProperties());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        return properties;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liguibase = new SpringLiquibase();
        liguibase.setDataSource(dataSource());
        liguibase.setChangeLog("classpath:db/changelog_test.xml");
        return liguibase;
    }
}
