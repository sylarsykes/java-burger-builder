/**
 * DrinksConfiguration.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.DRINKS_COCKTAIL_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.DRINKS_COCKTAIL_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.DRINKS_GLASS_COCKTAIL_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.DRINKS_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINKS_DRINK_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.COMPONENT_MODEL_SCAN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_DATA_SOURCE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_ENTITY_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_PERSISTENCE_UNIT;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_TRANSACTION_MANAGER;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = DRINKS_JPA_REPOSITORIES_BASE_PACKAGE, entityManagerFactoryRef = DRINKS_JPA_REPOSITORIES_ENTITY_MANAGER, transactionManagerRef = DRINKS_JPA_REPOSITORIES_TRANSACTION_MANAGER)
@Order(2)
public class DrinksConfiguration {

	@Bean(DRINKS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES)
	@ConfigurationProperties(prefix = DRINKS_DATA_SOURCE_PROPERTIES)
	public DataSourceProperties drinksSchemaDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(DRINKS_JPA_REPOSITORIES_DATA_SOURCE)
	@ConfigurationProperties(prefix = DRINKS_DATA_SOURCE_CONFIGURATION_PROPERTIES)
	public DataSource drinksSchemaDataSource(
			@Qualifier(DRINKS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES) DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(DRINKS_JPA_REPOSITORIES_ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean drinksEntityManagerFactory(
			EntityManagerFactoryBuilder eMFactoryBuilder,
			@Qualifier(DRINKS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES) final Map<String, String> properties,
			@Qualifier(DRINKS_JPA_REPOSITORIES_DATA_SOURCE) DataSource dataSource) {
		return eMFactoryBuilder.dataSource(dataSource)
				.packages(COMPONENT_MODEL_SCAN)
				.persistenceUnit(DRINKS_JPA_REPOSITORIES_PERSISTENCE_UNIT)
				.mappingResources(DRINKS_DRINK_JPA_REPOSITORIES_MAPPING_FILE,
						DRINKS_COCKTAIL_JPA_REPOSITORIES_MAPPING_FILE,
						DRINKS_COCKTAIL_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						DRINKS_GLASS_COCKTAIL_JPA_REPOSITORIES_MAPPING_FILE,
						DRINKS_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE)
				.properties(properties).build();
	}

	@Bean(DRINKS_JPA_REPOSITORIES_TRANSACTION_MANAGER)
	public PlatformTransactionManager drinksEntityTransactionManager(
			final @Qualifier(DRINKS_JPA_REPOSITORIES_ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean drinksEntityManagerFactory) {
		return new JpaTransactionManager(drinksEntityManagerFactory.getObject());
	}

}
