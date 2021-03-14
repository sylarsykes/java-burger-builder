/**
 * JasyptUtilBasicTextEncryptorConfigurationProperties.java 14 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.jasypt.util.text;

import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_STRONG;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * 
 * Configuration properties for {@link org.jasypt.util.text.StrongTextEncryptor}
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see http://www.jasypt.org/index.html
 * @see http://www.jasypt.org/api/jasypt/1.8/constant-values.html
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_STRONG)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class JasyptUtilStrongTextEncryptorConfigurationProperties {

	String beanName;
	
	String beanNameProperties;
	
	String algorithm = "PBEWithMD5AndTripleDES";
	
	String password;
	
}
