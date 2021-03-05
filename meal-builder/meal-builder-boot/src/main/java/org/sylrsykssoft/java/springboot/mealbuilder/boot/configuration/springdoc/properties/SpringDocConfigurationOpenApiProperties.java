/**
 * SpringDocConfigurationPublicApiProperties.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@ConfigurationProperties(prefix = "app.springdoc.configuration.open-api")
public class SpringDocConfigurationOpenApiProperties {
	
	String title;
	
	String description;
	
	String version;
	
	String licenseName;
	
	String url;
	
	String externalDocDescription;
	
	String externalDocUrl;
	
}
