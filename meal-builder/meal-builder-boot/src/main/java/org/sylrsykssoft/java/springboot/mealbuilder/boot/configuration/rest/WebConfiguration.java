/**
 * WebConfiguration.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.rest;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_COMPONENT_MODEL_MAPPER_SCAN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODEL_SERVICES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_REST_CONTROLLER_BASE_PACKAGE;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan(basePackages = { 
	API_COMPONENT_MODEL_MAPPER_SCAN, 
	API_MODEL_SERVICES_BASE_PACKAGE,
	API_REST_CONTROLLER_BASE_PACKAGE 
})
public class WebConfiguration {

}
