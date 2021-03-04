///**
// * IngredientConfiguration.java 27 feb. 2021
// *
// */
//package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;
//
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_DATA_SOURCE_CONFIGURATION_PROPERTIES;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_DATA_SOURCE_PROPERTIES;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_MODEL_BASE_PACKAGE;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_BASE_PACKAGE;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_ENTITY_MANAGER;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_PERSISTENCE_UNIT;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENTS_JPA_REPOSITORIES_TRANSACTION_MANAGER;
//import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_MODEL_BASE_PACKAGE;
//
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.zaxxer.hikari.HikariDataSource;
//
///**
// * @author juan.gonzalez.fernandez.jgf
// *
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = INGREDIENTS_JPA_REPOSITORIES_BASE_PACKAGE,
//        entityManagerFactoryRef = INGREDIENTS_JPA_REPOSITORIES_ENTITY_MANAGER,
//        transactionManagerRef= INGREDIENTS_JPA_REPOSITORIES_TRANSACTION_MANAGER
//)
//@Order(4)
//public class IngredientsConfiguration {
//
//	@Bean(INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES)
//	@ConfigurationProperties(prefix = INGREDIENTS_DATA_SOURCE_PROPERTIES)
//	public DataSourceProperties drinksSchemaDataSourceProperties() {
//		return new DataSourceProperties();
//	}
//	
//	@Bean(INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE)
//	@ConfigurationProperties(prefix = INGREDIENTS_DATA_SOURCE_CONFIGURATION_PROPERTIES)
//	public DataSource ingredientsSchemaDataSource(@Qualifier(INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES) DataSourceProperties dataSourceProperties) {
//		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//	}
//	
//	@Bean(INGREDIENTS_JPA_REPOSITORIES_ENTITY_MANAGER)
//	public LocalContainerEntityManagerFactoryBean ingredientsEntityManagerFactory(
//			EntityManagerFactoryBuilder eMFactoryBuilder,
//			@Qualifier(INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES) final Map<String, String> properties,
//			@Qualifier(INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE) DataSource dataSource) {
//		return eMFactoryBuilder.dataSource(dataSource).packages(INGREDIENTS_JPA_MODEL_BASE_PACKAGE, SAUCES_JPA_MODEL_BASE_PACKAGE)
//				.persistenceUnit(INGREDIENTS_JPA_REPOSITORIES_PERSISTENCE_UNIT).properties(properties).build();
//	}
//
//    @Bean(INGREDIENTS_JPA_REPOSITORIES_TRANSACTION_MANAGER)
//    public PlatformTransactionManager ingredientsEntityTransactionManager(
//            final @Qualifier(INGREDIENTS_JPA_REPOSITORIES_ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean ingredientsEntityManagerFactory) {
//        return new JpaTransactionManager(ingredientsEntityManagerFactory.getObject());
//    }
//    
//}
