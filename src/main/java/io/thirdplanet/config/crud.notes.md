Implementing CRUD functionality
for an entiry
=========================================
We have now configured the Spring application
context and configured our web application
to load it during start up

Review...what composes our Application context ?
===================================================
@ComponentScan annotation....in this example, the Spring IoC container is
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