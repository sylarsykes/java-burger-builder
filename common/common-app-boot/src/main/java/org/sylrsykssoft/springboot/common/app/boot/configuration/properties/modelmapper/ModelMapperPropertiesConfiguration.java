/**
 * ModelMapperPropertiesConfiguration.java 22 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_MODEL_MAPPER_PROPERTIES;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.mappingcontext.ModelMapperMappingContextPropertiesConfiguration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_MODEL_MAPPER_PROPERTIES)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ModelMapperPropertiesConfiguration {

	String beanName;
	
	String beanNameProperties;
	
	Set<ModelMapperMappingContextPropertiesConfiguration> mappingContexts;
}
