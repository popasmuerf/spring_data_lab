package io.thirdplanet.config;

import org.hibernate.metamodel.relational.Database;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan(basePackages = { "io.thirdplanet.spring_data_lab.controller", "io.thirdplanet.spring_data_lab.service" })
@EnableJpaRepositories("io.thirdplanet.spring_data_lab")
@EnableTransactionManagement
@EnableAsync
@EnableWebMvc
@PropertySource("classpath:application.properties")
/**
 * Creating the application context configuration skeleton.... 1.
 * The @Configuration annotation indentifies the class as an application context
 * configuration class
 * 
 * 2. The component scanning directives are configured with the
 * 
 * @ComponentScan annotation....in this example, the Spring IoC container is
 *                configured to scan for the packages containing our ontroller
 *                and service classes.
 * 
 *                3. @EnableJpaRepositories annotation is used to enable Spring
 *                Data JPA and configure the base package of our repositories.
 * 
 *                4. The @EnableTransactionManagement annotation enables the
 *                annotation-driven transaction management of the Spring
 *                Framework
 * 
 *                5. The @EnableWebMvc annotation imports the default
 *                configuration of Spring MVC
 * 
 *                6. The properties file containing the values of the
 *                configuration is importd by using teh @PeopertySource
 *                annotation. We can access the property values stored in this
 *                file by using the implementation of the Enviroment interface
 *                that is is injected by the Spring IoC container.....
 * 
 *                Note: We can also configure Spring Data JPA by using XML. We
 *                can do this by adding the repositories namespace element of
 *                Spring Data JPA to our application context configuration file.
 * 
 * 
 * 
 *                Configuring the data source bean
 *                ---------------------------------- We will start the
 *                configuration of the data source bean by adding a dataSource()
 *                method to the ApplicationContext class and annotating this
 *                method with the @Bean annotation. The implementation of this
 *                method is as follows:
 * 
 *                1. Create an instance of the BoneCPDataCource calss 2. Set the
 *                database connection details 3. Return the created object
 * 
 *                The configuration of the data source beans is given as
 *                follows..
 * 
 */
public class ApplicationContext extends WebMvcConfigurerAdapter {
    @Resource
    private Environment env;
    private ServletContext servletContext;

    // Add our configuration somewhere in this class.....

    @Bean
    public BoneCPDataSource dataSource() {
        BoneCPDataSource ds = new BoneCPDataSource();
        ds.setDriverClass(env.getRequiredProperty("db.driver"));
        ds.setJdbcUrl(env.getRequiredProperty("db.url"));
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));
        return ds;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));

        Properties p = new Properties();
        p.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        p.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        p.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        p.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
        p.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        em.setJpaProperties(p);

        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    





}