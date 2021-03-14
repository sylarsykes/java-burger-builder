/**
 * JasyptConfiguration.java 13 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.jasypt;

import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_PASSWORD;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_BASIC;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_STRONG;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.jasypt.JasyptSimplePBEConfigurationProperties;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.jasypt.util.text.JasyptUtilBasicTextEncryptorConfigurationProperties;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.jasypt.util.text.JasyptUtilStrongTextEncryptorConfigurationProperties;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

/**
 * JasyptConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://www.devglan.com/online-tools/jasypt-online-encryption-decryption
 * @see https://www.codejava.net/frameworks/spring-boot/spring-boot-password-encryption
 *
 */
@Configuration
@EnableEncryptableProperties
@EncryptablePropertySource(name = "EncryptedProperties", value = "classpath:application-credentials.yml")
public class JasyptSimplePBEConfiguration {

	@Bean
	public JasyptSimplePBEConfigurationProperties mealBuilderJasyptSimplePBEConfigurationProperties() {
		return new JasyptSimplePBEConfigurationProperties();
	}

	@Bean(name = "jasyptStringEncryptor")
	public StringEncryptor getPasswordEncryptor(
			@Qualifier("mealBuilderJasyptSimplePBEConfigurationProperties") JasyptSimplePBEConfigurationProperties jasyptConfigurationProperties) {
		final PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		final SimpleStringPBEConfig config = new SimpleStringPBEConfig();

		config.setPassword(jasyptConfigurationProperties.getPassword());

		config.setAlgorithm(jasyptConfigurationProperties.getAlgorithm());
		config.setKeyObtentionIterations(jasyptConfigurationProperties.getKeyObtentionIterations());
		config.setPoolSize(jasyptConfigurationProperties.getPoolSize());
		config.setSaltGeneratorClassName(jasyptConfigurationProperties.getSaltGeneratorClassName());
		if (jasyptConfigurationProperties.getIvGeneratorClassName() != null) {
			config.setIvGeneratorClassName(jasyptConfigurationProperties.getIvGeneratorClassName());
		}
		config.setProviderName(jasyptConfigurationProperties.getProviderName());
		if (jasyptConfigurationProperties.getProviderClassName() != null) {
			config.setProviderClassName(jasyptConfigurationProperties.getProviderClassName());
		}
		config.setStringOutputType(jasyptConfigurationProperties.getStringOutputType());

		encryptor.setConfig(config);

		return encryptor;
	}

	@Bean
	@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_PASSWORD)
	public JasyptSimplePBEConfigurationProperties mealBuilderJasyptUtilPasswordEncryptorConfigurationProperties() {
		return new JasyptSimplePBEConfigurationProperties();
	}

	@Bean
	public StringEncryptor jasyptUtilPasswordEncryptor(
			@Qualifier("mealBuilderJasyptUtilPasswordEncryptorConfigurationProperties") JasyptSimplePBEConfigurationProperties jasyptConfigurationProperties) {
		final PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		final SimpleStringPBEConfig config = new SimpleStringPBEConfig();

		config.setAlgorithm(jasyptConfigurationProperties.getAlgorithm());
		config.setKeyObtentionIterations(jasyptConfigurationProperties.getKeyObtentionIterations());
		config.setPoolSize(jasyptConfigurationProperties.getPoolSize());
		config.setSaltGeneratorClassName(jasyptConfigurationProperties.getSaltGeneratorClassName());
		if (jasyptConfigurationProperties.getIvGeneratorClassName() != null) {
			config.setIvGeneratorClassName(jasyptConfigurationProperties.getIvGeneratorClassName());
		}
		config.setProviderName(jasyptConfigurationProperties.getProviderName());
		if (jasyptConfigurationProperties.getProviderClassName() != null) {
			config.setProviderClassName(jasyptConfigurationProperties.getProviderClassName());
		}
		config.setStringOutputType(jasyptConfigurationProperties.getStringOutputType());

		encryptor.setConfig(config);

		return encryptor;
	}

	@Bean
	@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_BASIC)
	public JasyptUtilBasicTextEncryptorConfigurationProperties mealBuilderJasyptUtilBasicTextEncryptorConfigurationProperties() {
		return new JasyptUtilBasicTextEncryptorConfigurationProperties();
	}

	@Bean
	public BasicTextEncryptor jasypUtiltBasicTextEncryptor(
			@Qualifier("mealBuilderJasyptUtilBasicTextEncryptorConfigurationProperties") JasyptUtilBasicTextEncryptorConfigurationProperties jasyptUtilBasicTextConfigurationProperties) {
		return new BasicTextEncryptor();
	}

	@Bean
	@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_STRONG)
	public JasyptUtilStrongTextEncryptorConfigurationProperties mealBuilderJasyptUtilStrongTextEncryptorConfigurationProperties() {
		return new JasyptUtilStrongTextEncryptorConfigurationProperties();
	}

	@Bean
	public StrongTextEncryptor jasypUtiltStrongTextEncryptor(
			@Qualifier("mealBuilderJasyptUtilStrongTextEncryptorConfigurationProperties") JasyptUtilStrongTextEncryptorConfigurationProperties jasyptUtilStrongTextConfigurationProperties) {
		return new StrongTextEncryptor();
	}

}
