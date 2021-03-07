/**
 * SaucesConfiguration.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_SAUCES;

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
	
	@Bean(SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES)
	@ConfigurationProperties(prefix = MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_SAUCES)
	public DatasourceConfigurationProperties saucesConfigurationDataSourceProperties() {
		return new DatasourceConfigurationProperties();
	}
	
	@Bean(SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER)
	public LocalContainerEntityManagerFactoryBean saucesEntityManagerFactory(
			final EntityManagerFactoryBuilder eMFactoryBuilder,
			@Qualifier(SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES) final Map<String, String> properties,
			@Qualifier(SAUCES_JPA_REPOSITORIES_DATA_SOURCE) final DataSource dataSource,
			@Qualifier(SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES) final DatasourceConfigurationProperties dataSourceConfigurationProperties) {
		
		final String[] packages = dataSourceConfigurationProperties.getPackages()
				.toArray(new String[dataSourceConfigurationProperties.getPackages().size()]);

		final String[] mappingResources = dataSourceConfigurationProperties.getMappingResources()
				.toArray(new String[dataSourceConfigurationProperties.getMappingResources().size()]);

		return eMFactoryBuilder.dataSource(dataSource).packages(packages)
				.persistenceUnit(dataSourceConfigurationProperties.getPersistenceUnit())
				.mappingResources(mappingResources).properties(properties).build();
	}

    @Bean(SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER)
    public PlatformTransactionManager saucesEntityTransactionManager(
            final @Qualifier(SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean saucesEntityManagerFactory) {
        return new JpaTransactionManager(saucesEntityManagerFactory.getObject());
    }
    
}
