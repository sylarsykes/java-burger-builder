/**
 * SpringDocConfiguration.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.springdoc;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

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
		
		if (isNotEmpty(mealBuilderConfigPublicApiProps.getPaths())) {
			return GroupedOpenApi.builder().group(mealBuilderConfigPublicApiProps.getGroup())
					.pathsToMatch(mealBuilderConfigPublicApiProps.getPaths()
							.toArray(new String[mealBuilderConfigPublicApiProps.getPaths().size()]))
					.build();
		} else {
			return GroupedOpenApi.builder().group(mealBuilderConfigPublicApiProps.getGroup())
					.pathsToMatch("/public/**")
					.build();
		}
		
	}

	@Bean
	public SpringDocConfigurationAdminApiProperties mealBuilderConfigurationAdminApiProperties() {
		return new SpringDocConfigurationAdminApiProperties();
	}

	@Bean
	public GroupedOpenApi adminApi(
			@Qualifier("mealBuilderConfigurationAdminApiProperties") final SpringDocConfigurationAdminApiProperties mealBuilderConfigAdminApiProps) {
		
		if (isNotEmpty(mealBuilderConfigAdminApiProps.getPaths())) {
			return GroupedOpenApi
					.builder().group(mealBuilderConfigAdminApiProps.getGroup()).pathsToMatch(mealBuilderConfigAdminApiProps
							.getPaths().toArray(new String[mealBuilderConfigAdminApiProps.getPaths().size()]))
					.build();
		} else {
			return GroupedOpenApi
					.builder().group(mealBuilderConfigAdminApiProps.getGroup()).pathsToMatch("/admin/**")
					.build();
		}
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
