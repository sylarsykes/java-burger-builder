/**
 * SpringDocConfigurationPublicApiProperties.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.springdoc;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_PUBLIC_API;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SpringDocConfigurationPublicApiProperties
 * 
 * <pre>
 * 	Bean definition
 * 	{@code
 *  	@Bean
		public SpringDocConfigurationPublicApiProperties commonAppBootConfigurationPublicApiProperties() {
			return new SpringDocConfigurationPublicApiProperties();
		}
 *  }
 * </pre>
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_PUBLIC_API)
@NoArgsConstructor
@Getter
@Setter
public class SpringDocConfigurationPublicApiProperties {
	
	String group;
	
	String basePath;
	
	Set<String> paths;
	
	Set<String> packages;

}
