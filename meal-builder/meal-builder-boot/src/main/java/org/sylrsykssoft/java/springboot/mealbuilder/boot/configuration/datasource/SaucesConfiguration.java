/**
 * SaucesConfiguration.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.SAUCES_BURGER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.SAUCES_BURGER_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.SAUCES_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_MODEL_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_PERSISTENCE_UNIT;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER;

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
@EnableJpaRepositories(basePackages = SAUCES_JPA_REPOSITORIES_BASE_PACKAGE,
        entityManagerFactoryRef = SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER,
        transactionManagerRef= SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER
)
@Order(3)
public class SaucesConfiguration {

	@Bean(SAUCES_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES)
	@ConfigurationProperties(prefix = SAUCES_DATA_SOURCE_PROPERTIES)
	public DataSourceProperties saucesSchemaDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(SAUCES_JPA_REPOSITORIES_DATA_SOURCE)
	@ConfigurationProperties(prefix = SAUCES_DATA_SOURCE_CONFIGURATION_PROPERTIES)
	public DataSource saucesSchemaDataSource(@Qualifier(SAUCES_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES) DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Bean(SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean saucesEntityManagerFactory(
			EntityManagerFactoryBuilder eMFactoryBuilder,
			@Qualifier(SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES) final Map<String, String> properties,
			@Qualifier(SAUCES_JPA_REPOSITORIES_DATA_SOURCE) DataSource dataSource) {
		return eMFactoryBuilder.dataSource(dataSource)
				.packages(SAUCES_JPA_MODEL_BASE_PACKAGE)
				.persistenceUnit(SAUCES_JPA_REPOSITORIES_PERSISTENCE_UNIT)
				.mappingResources(SAUCES_BURGER_JPA_REPOSITORIES_MAPPING_FILE,
						SAUCES_BURGER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE,
						SAUCES_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE)
				.properties(properties)
				.build();
	}

    @Bean(SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER)
    public PlatformTransactionManager saucesEntityTransactionManager(
            final @Qualifier(SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean saucesEntityManagerFactory) {
        return new JpaTransactionManager(saucesEntityManagerFactory.getObject());
    }
    
}
