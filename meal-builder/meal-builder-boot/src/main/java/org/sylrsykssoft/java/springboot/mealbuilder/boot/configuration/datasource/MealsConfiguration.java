/**
 * MealsDataSourceConfiguration.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_ENTITY_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_MEALS;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.datasource.DatasourceConfigurationProperties;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Datasource configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = MEALS_JPA_REPOSITORIES_BASE_PACKAGE, 
	entityManagerFactoryRef = MEALS_JPA_REPOSITORIES_ENTITY_MANAGER, 
	transactionManagerRef = MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER)
@Order(1)
public class MealsConfiguration {

	@Primary
	@Bean(MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES)
	@ConfigurationProperties(prefix = MEALS_DATA_SOURCE_PROPERTIES)
	public DataSourceProperties mealsSchemaDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(MEALS_JPA_REPOSITORIES_DATA_SOURCE)
	@ConfigurationProperties(prefix = MEALS_DATA_SOURCE_CONFIGURATION_PROPERTIES)
	public DataSource mealsSchemaDataSource(
			@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES) DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(MEALS_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES)
	@ConfigurationProperties(prefix = MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_MEALS)
	public DatasourceConfigurationProperties mealsConfigurationDataSourceProperties() {
		return new DatasourceConfigurationProperties();
	}

	@Primary
	@Bean(MEALS_JPA_REPOSITORIES_ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean mealsEntityManagerFactory(
			final EntityManagerFactoryBuilder eMFactoryBuilder,
			@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES) final Map<String, String> properties,
			@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE) final DataSource dataSource,
			@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES) final DatasourceConfigurationProperties dataSourceConfigurationProperties) {

		final String[] packages = dataSourceConfigurationProperties.getPackages()
				.toArray(new String[dataSourceConfigurationProperties.getPackages().size()]);

		final String[] mappingResources = dataSourceConfigurationProperties.getMappingResources()
				.toArray(new String[dataSourceConfigurationProperties.getMappingResources().size()]);

		return eMFactoryBuilder.dataSource(dataSource).packages(packages)
				.persistenceUnit(dataSourceConfigurationProperties.getPersistenceUnit())
				.mappingResources(mappingResources).properties(properties).build();
	}

	@Primary
	@Bean(MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER)
	public PlatformTransactionManager mealsEntityTransactionManager(
			@Qualifier(MEALS_JPA_REPOSITORIES_ENTITY_MANAGER) final LocalContainerEntityManagerFactoryBean mealsEntityManagerFactory) {
		return new JpaTransactionManager(mealsEntityManagerFactory.getObject());
	}

}
