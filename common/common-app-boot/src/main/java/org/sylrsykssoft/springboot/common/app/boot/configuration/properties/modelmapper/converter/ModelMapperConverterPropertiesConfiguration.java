/**
 * ModelMapperPropertiesConfiguration.java 22 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.converter;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_MODEL_MAPPER_CONVERTER_PROPERTIES;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_MODEL_MAPPER_CONVERTER_PROPERTIES)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ModelMapperConverterPropertiesConfiguration {

	String beanName;
	
	String beanNameProperties;
	
	Class<?> converterClassType;
	
}
