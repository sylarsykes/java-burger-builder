/**
 * I18nMessageSourceConfiguration.java 1 abr. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.i18n;

import java.util.Locale;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.i18n.I18nMessageSourceConfigurationProperties;

/**
 * I18nMessageSourceConfiguration
 * 
 * <pre>
 * 	See: application.yml spring.messages
 * </pre>
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class I18nMessageSourceConfiguration {

	@Bean
	public I18nMessageSourceConfigurationProperties i18nMessageSourceConfigurationProperties() {
		return new I18nMessageSourceConfigurationProperties();
	}

	@Bean("messageSource")
	public ResourceBundleMessageSource messageSource(
			@Qualifier("i18nMessageSourceConfigurationProperties") @NotNull final I18nMessageSourceConfigurationProperties i18nMessageSourceConfigurationProperties) {
		final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setAlwaysUseMessageFormat(i18nMessageSourceConfigurationProperties.isAlwaysUseMessageFormat());
		source.setBasename(i18nMessageSourceConfigurationProperties.getBasename());
		source.setCacheSeconds(i18nMessageSourceConfigurationProperties.getCacheDuration());
		source.setDefaultEncoding(i18nMessageSourceConfigurationProperties.getEncoding());
		source.setFallbackToSystemLocale(i18nMessageSourceConfigurationProperties.isFallbackToSystemLocale());
		source.setUseCodeAsDefaultMessage(i18nMessageSourceConfigurationProperties.isUseCodeAsDefaultMessage());
		return source;
	}

	@Bean
	public MessageSourceAccessor getMessageSourceAccessor(final MessageSource messageSource) {
		return new MessageSourceAccessor(messageSource, Locale.UK);
	}

}
