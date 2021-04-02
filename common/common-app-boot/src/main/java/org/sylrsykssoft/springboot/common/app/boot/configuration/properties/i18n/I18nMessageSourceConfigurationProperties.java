/**
 * I18nConfigurationProperties.java 2 abr. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.i18n;

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
@ConfigurationProperties(prefix = "spring.messages")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class I18nMessageSourceConfigurationProperties {

	boolean alwaysUseMessageFormat;
	
	String basename;
	
	int cacheDuration;
	
	String encoding;
	
	boolean fallbackToSystemLocale;
	
	boolean useCodeAsDefaultMessage;
	
}
