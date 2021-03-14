/**
 * JasyptConfigurationProperties.java 14 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.jasypt;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_WEBPBE;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * 
 * Configuration properties for {@link org.jasypt.encryption.pbe.config.WebPBEConfig}, {@link org.jasypt.encryption.pbe.config.WebStringPBEConfig}
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see http://www.jasypt.org/index.html
 * @see http://www.jasypt.org/api/jasypt/1.8/constant-values.html
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_WEBPBE)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class JasyptWebPBEConfigurationProperties {

	String beanName;
	
	String algorithm;
	
	String password;
	
	String keyObtentionIterations;
	
	String saltGeneratorClassName;
	
	String ivGeneratorClassName;
	
	String providerName;
	
	String providerClassName;
	
	String poolSize;
	
	String name;
	
	String validationWord;
	
	String stringOutputType;
}
