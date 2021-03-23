/**
 * CommonAppBootModelMapperConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.AuditModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.CodeModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.DescriptionModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedFieldNameModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedValueModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.NameModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.AuditModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.CodeModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.DescriptionModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedFieldNameModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedValueModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.NameModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.ModelMapperPropertiesConfiguration;

/**
 * Model mapper configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan(basePackageClasses = CommonModelMapperMappingContextConverterConfiguration.class)
public class CommonModelMapperConfiguration {

//	@Autowired
//	ApplicationContext context = new AnnotationConfigApplicationContext(
//			CommonModelMapperMappingContextConverterConfiguration.class);

	@Bean
	public ModelMapperPropertiesConfiguration commonModelMapperConfigurationProperties() {
		return new ModelMapperPropertiesConfiguration();
	}

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@SuppressWarnings("squid:S107")
	@Bean(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper commonModelMapper(
			@Qualifier("auditModelDTOMappingContextConverter") @NotNull final AuditModelDTOMappingContextConverter auditModelDTOMappingContextConverter,
			@Qualifier("codeModelDTOMappingContextConverter") @NotNull final CodeModelDTOMappingContextConverter codeModelDTOMappingContextConverter,
			@Qualifier("descriptionModelDTOMappingContextConverter") @NotNull final DescriptionModelDTOMappingContextConverter descriptionModelDTOMappingContextConverter,
			@Qualifier("localizedFieldNameModelDTOMappingContextConverter") @NotNull final LocalizedFieldNameModelDTOMappingContextConverter localizedFieldNameModelDTOMappingContextConverter,
			@Qualifier("localizedModelDTOMappingContextConverter") @NotNull final LocalizedModelDTOMappingContextConverter localizedModelDTOMappingContextConverter,
			@Qualifier("localizedValueModelDTOMappingContextConverter") @NotNull final LocalizedValueModelDTOMappingContextConverter localizedValueModelDTOMappingContextConverter,
			@Qualifier("nameModelDTOMappingContextConverter") @NotNull final NameModelDTOMappingContextConverter nameModelDTOMappingContextConverter,
			@Qualifier("auditModelMappingContextConverter") @NotNull final AuditModelMappingContextConverter auditModelMappingContextConverter,
			@Qualifier("codeModelMappingContextConverter") @NotNull final CodeModelMappingContextConverter codeModelMappingContextConverter,
			@Qualifier("descriptionModelMappingContextConverter") @NotNull final DescriptionModelMappingContextConverter descriptionModelMappingContextConverter,
			@Qualifier("localizedFieldNameModelMappingContextConverter") @NotNull final LocalizedFieldNameModelMappingContextConverter localizedFieldNameModelMappingContextConverter,
			@Qualifier("localizedModelMappingContextConverter") @NotNull final LocalizedModelMappingContextConverter localizedModelMappingContextConverter,
			@Qualifier("localizedValueModelMappingContextConverter") @NotNull final LocalizedValueModelMappingContextConverter localizedValueModelMappingContextConverter,
			@Qualifier("nameModelMappingContextConverter") @NotNull final NameModelMappingContextConverter nameModelMappingContextConverter) {
		final ModelMapper mapper = new ModelMapper();

		// DTO converters
		mapper.addConverter(auditModelDTOMappingContextConverter, AuditModel.class, AuditModelDTO.class);
		mapper.addConverter(codeModelDTOMappingContextConverter, CodeModel.class, CodeModelDTO.class);
		mapper.addConverter(descriptionModelDTOMappingContextConverter, DescriptionModel.class,
				DescriptionModelDTO.class);
		mapper.addConverter(localizedFieldNameModelDTOMappingContextConverter, LocalizedFieldNameModel.class,
				LocalizedFieldNameModelDTO.class);
		mapper.addConverter(localizedModelDTOMappingContextConverter, LocalizedModel.class, LocalizedModelDTO.class);
		mapper.addConverter(localizedValueModelDTOMappingContextConverter, LocalizedValueModel.class,
				LocalizedValueModelDTO.class);
		mapper.addConverter(nameModelDTOMappingContextConverter, NameModel.class, NameModelDTO.class);

		// Model converters
		mapper.addConverter(auditModelMappingContextConverter, AuditModelDTO.class, AuditModel.class);
		mapper.addConverter(codeModelMappingContextConverter, CodeModelDTO.class, CodeModel.class);
		mapper.addConverter(descriptionModelMappingContextConverter, DescriptionModelDTO.class, DescriptionModel.class);
		mapper.addConverter(localizedFieldNameModelMappingContextConverter, LocalizedFieldNameModelDTO.class,
				LocalizedFieldNameModel.class);
		mapper.addConverter(localizedModelMappingContextConverter, LocalizedModelDTO.class, LocalizedModel.class);
		mapper.addConverter(localizedValueModelMappingContextConverter, LocalizedValueModelDTO.class,
				LocalizedValueModel.class);
		mapper.addConverter(nameModelMappingContextConverter, NameModelDTO.class, NameModel.class);

		return mapper;
	}
}
