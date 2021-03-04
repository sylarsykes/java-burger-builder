/**
 * MealsDataSourceConfiguration.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.MEALS_BREAD_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.MEALS_BURGER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.MEALS_BURGER_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.MEALS_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.DessertApiConstants.MEALS_DESSERT_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.DessertApiConstants.MEALS_DESSERT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.MEALS_FOOD_STARTER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.MEALS_FOOD_STARTER_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.COMPONENT_MODEL_SCAN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_ENTITY_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_PERSISTENCE_UNIT;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SaladApiConstants.MEALS_SALAD_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SaladApiConstants.MEALS_SALAD_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.MEALS_SANDWICH_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.MEALS_SANDWICH_JPA_REPOSITORIES_MAPPING_FILE;

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

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = MEALS_JPA_REPOSITORIES_BASE_PACKAGE,
        entityManagerFactoryRef = MEALS_JPA_REPOSITORIES_ENTITY_MANAGER,
        transactionManagerRef= MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER
)
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
	public DataSource mealsSchemaDataSource(@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES) DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(MEALS_JPA_REPOSITORIES_ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean mealsEntityManagerFactory(
			EntityManagerFactoryBuilder eMFactoryBuilder,
			@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES) final Map<String, String> properties,
			@Qualifier(MEALS_JPA_REPOSITORIES_DATA_SOURCE) DataSource dataSource) {
		return eMFactoryBuilder.dataSource(dataSource)
				.packages(COMPONENT_MODEL_SCAN)
				.persistenceUnit(MEALS_JPA_REPOSITORIES_PERSISTENCE_UNIT)
				.mappingResources(MEALS_BURGER_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_BURGER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_BREAD_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_DESSERT_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_DESSERT_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_FOOD_STARTER_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_FOOD_STARTER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_SALAD_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_SALAD_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_SANDWICH_JPA_REPOSITORIES_MAPPING_FILE,
						MEALS_SANDWICH_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE)
				.properties(properties)
				.build();
	}

    @Primary
    @Bean(MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER)
    public PlatformTransactionManager mealsEntityTransactionManager(
    		final @Qualifier(MEALS_JPA_REPOSITORIES_ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean mealsEntityManagerFactory) {
        return new JpaTransactionManager(mealsEntityManagerFactory.getObject());
    }
    
}
