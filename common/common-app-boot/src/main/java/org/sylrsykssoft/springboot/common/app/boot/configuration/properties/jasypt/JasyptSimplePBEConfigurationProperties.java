/**
 * JasyptConfigurationProperties.java 14 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.jasypt;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_SIMPLEPBE;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * 
 * Configuration properties for {@link org.jasypt.encryption.pbe.config.SimplePBEConfig}, {@link org.jasypt.encryption.pbe.config.SimpleStringPBEConfig}
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see http://www.jasypt.org/index.html
 * @see http://www.jasypt.org/api/jasypt/1.8/constant-values.html
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_SIMPLEPBE)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class JasyptSimplePBEConfigurationProperties {

	String beanName;
	
	String beanNameProperties;
	
	String algorithm;
	
	String password;
	
	String keyObtentionIterations;
	
	String saltGeneratorClassName;
	
	String ivGeneratorClassName;
	
	String providerName;
	
	String providerClassName;
	
	String poolSize;
	
	String stringOutputType;
}
