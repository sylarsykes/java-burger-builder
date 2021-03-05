/**
 * SpringDocConfiguration.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_REST_CONTROLLER_ADMIN_API_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_REST_CONTROLLER_PUBLIC_API_PACKAGE;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc.properties.SpringDocConfigurationAdminApiProperties;
import org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc.properties.SpringDocConfigurationOpenApiProperties;
import org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc.properties.SpringDocConfigurationPublicApiProperties;

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

		final String[] paths = (isNotEmpty(mealBuilderConfigPublicApiProps.getPaths()))
				? mealBuilderConfigPublicApiProps.getPaths()
						.toArray(new String[mealBuilderConfigPublicApiProps.getPaths().size()])
				: new String[] { "/api/v1/public/**" };

		final String packagesToScan[] = { DRINKS_REST_CONTROLLER_PUBLIC_API_PACKAGE };

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

		final String[] paths = (isNotEmpty(mealBuilderConfigAdminApiProps.getPaths()))
				? mealBuilderConfigAdminApiProps.getPaths()
						.toArray(new String[mealBuilderConfigAdminApiProps.getPaths().size()])
				: new String[] { "/api/v1/admin/**" };

		final String packagesToScan[] = { DRINKS_REST_CONTROLLER_ADMIN_API_PACKAGE };

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
