/**
 * SpringDocConfigurationPublicApiProperties.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc.properties;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = "app.springdoc.configuration.public-api")
@Data
public class SpringDocConfigurationPublicApiProperties {
	
	String group;
	
	String basePath;
	
	Set<String> paths;

}
