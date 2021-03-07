/**
 * SpringDocConfigurationAdminApiProperties.java 6 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.springdoc;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_ADMIN_API;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * SpringDocConfigurationAdminApiProperties
 * 
 * <pre>
 * 	Bean definition
 * 	{@code
 *  	@Bean
		public SpringDocConfigurationAdminApiProperties commonAppBootConfigurationAdminApiProperties() {
			return new SpringDocConfigurationAdminApiProperties();
		}
 *  }
 * </pre>
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_ADMIN_API)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class SpringDocConfigurationAdminApiProperties {
	
	String group;
	
	String basePath;
	
	Set<String> paths;
	
	Set<String> packages;
	
}
