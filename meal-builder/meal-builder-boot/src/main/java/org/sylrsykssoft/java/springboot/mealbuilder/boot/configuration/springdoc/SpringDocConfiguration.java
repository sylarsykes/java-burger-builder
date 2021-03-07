/**
 * SpringDocConfiguration.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.springdoc.SpringDocConfigurationAdminApiProperties;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.springdoc.SpringDocConfigurationOpenApiProperties;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.springdoc.SpringDocConfigurationPublicApiProperties;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * SpringDocConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class SpringDocConfiguration {

	@Bean
	public SpringDocConfigurationPublicApiProperties mealBuilderConfigurationPublicApiProperties() {
		return new SpringDocConfigurationPublicApiProperties();
	}

	@Bean
	public GroupedOpenApi publicApi(
			@Qualifier("mealBuilderConfigurationPublicApiProperties") final SpringDocConfigurationPublicApiProperties mealBuilderConfigPublicApiProps) {

		final String[] paths = mealBuilderConfigPublicApiProps.getPaths()
				.toArray(new String[mealBuilderConfigPublicApiProps.getPaths().size()]);

		final String[] packagesToScan = mealBuilderConfigPublicApiProps.getPackages()
				.toArray(new String[mealBuilderConfigPublicApiProps.getPackages().size()]);

		return GroupedOpenApi.builder().group(mealBuilderConfigPublicApiProps.getGroup()).pathsToMatch(paths)
				.packagesToScan(packagesToScan).build();

	}

	@Bean
	public SpringDocConfigurationAdminApiProperties mealBuilderConfigurationAdminApiProperties() {
		return new SpringDocConfigurationAdminApiProperties();
	}

	@Bean
	public GroupedOpenApi adminApi(
			@Qualifier("mealBuilderConfigurationAdminApiProperties") final SpringDocConfigurationAdminApiProperties mealBuilderConfigAdminApiProps) {

		final String[] paths = mealBuilderConfigAdminApiProps.getPaths()
				.toArray(new String[mealBuilderConfigAdminApiProps.getPaths().size()]);

		final String[] packagesToScan = mealBuilderConfigAdminApiProps.getPackages()
				.toArray(new String[mealBuilderConfigAdminApiProps.getPackages().size()]);

		return GroupedOpenApi.builder().group(mealBuilderConfigAdminApiProps.getGroup()).pathsToMatch(paths)
				.packagesToScan(packagesToScan).build();
	}

	@Bean
	public SpringDocConfigurationOpenApiProperties mealBuilderConfigurationOpenApiProperties() {
		return new SpringDocConfigurationOpenApiProperties();
	}

	@Bean
	public OpenAPI mealBuilderOpenAPI(
			@Qualifier("mealBuilderConfigurationOpenApiProperties") final SpringDocConfigurationOpenApiProperties mealBuilderConfigOpenApiProps) {
		return new OpenAPI()
				.info(new Info().title(mealBuilderConfigOpenApiProps.getTitle())
						.description(mealBuilderConfigOpenApiProps.getDescription())
						.version(mealBuilderConfigOpenApiProps.getVersion())
						.license(new License().name(mealBuilderConfigOpenApiProps.getLicenseName())
								.url(mealBuilderConfigOpenApiProps.getUrl())))
				.externalDocs(new ExternalDocumentation()
						.description(mealBuilderConfigOpenApiProps.getExternalDocDescription())
						.url(mealBuilderConfigOpenApiProps.getExternalDocUrl()));
	}

}
