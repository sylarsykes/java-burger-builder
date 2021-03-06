/**
 * SpringDocConfigurationPublicApiProperties.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.springdoc;


import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_OPEN_API;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SpringDocConfigurationOpenApiProperties
 * 
 * <pre>
 * 	Bean definition
 * 	{@code
 *  	@Bean
		public SpringDocConfigurationOpenApiProperties commonAppBootConfigurationOpenApiProperties() {
			return new SpringDocConfigurationOpenApiProperties();
		}
 *  }
 * </pre>
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_OPEN_API)
@NoArgsConstructor
@Getter
@Setter
public class SpringDocConfigurationOpenApiProperties {
	
	String title;
	
	String description;
	
	String version;
	
	String licenseName;
	
	String url;
	
	String externalDocDescription;
	
	String externalDocUrl;
	
}
