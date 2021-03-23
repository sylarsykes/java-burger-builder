/**
 * ModelMapperPropertiesConfiguration.java 22 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.mappingcontext;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_MODEL_MAPPER_MAPPING_CONTEXT_PROPERTIES;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.converter.ModelMapperConverterPropertiesConfiguration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_MODEL_MAPPER_MAPPING_CONTEXT_PROPERTIES)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ModelMapperMappingContextPropertiesConfiguration {

	String beanName;
	
	String beanNameProperties;
	
	Class<?> sourceType;
	
	Class<?> destinationType;
	
	ModelMapperConverterPropertiesConfiguration converterPropertiesConfiguration;
}
