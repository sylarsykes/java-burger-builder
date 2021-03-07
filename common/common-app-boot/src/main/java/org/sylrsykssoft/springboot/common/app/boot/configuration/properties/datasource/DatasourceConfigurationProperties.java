/**
 * DatasourceConfigurationProperties.java 7 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.datasource;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * DatasourceConfigurationProperties
 * 
 * <pre>
 * 	Bean definition
 * 	{@code
 *  	@Bean
		public DatasourceConfigurationProperties commonAppBootConfigurationDatasourceProperties() {
			return new DatasourceConfigurationProperties();
		}
 *  }
 * </pre>
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DatasourceConfigurationProperties {

	String schemaDataSource;
	
	String schemaDataSourceProperties;
	
	String schemaDataSourceCustomProperties;
	
	String entityManagerFactory;
	
	String persistenceUnit;
	
	String entityTransactionManager;
	
	Set<String> packages;
	
	Set<String> mappingResources;
	
}
