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
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.AuditModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.CodeModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.DescriptionModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.NameModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.AuditModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.CodeModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.DescriptionModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.NameModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.AuditModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.CodeModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.DescriptionModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.NameModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.AuditModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.CodeModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.DescriptionModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.NameModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

/**
 * Model mapper configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class CommonModelMapperConfiguration {

	@Bean
	public AuditModelDTOMapperConverter auditModelDTOMapperConverter() {
		return new AuditModelDTOMapperConverter();
	}

	@Bean
	public AuditModelDTOMappingContextConverter auditModelDTOMappingContextConverter(
			@Qualifier("auditModelDTOMapperConverter") @NotNull final AuditModelDTOMapperConverter converter) {
		return new AuditModelDTOMappingContextConverter(converter);
	}

	@Bean
	public AuditModelMapperConverter auditModelMapperConverter() {
		return new AuditModelMapperConverter();
	}

	@Bean
	public AuditModelMappingContextConverter auditModelMappingContextConverter(
			@Qualifier("auditModelMapperConverter") @NotNull final AuditModelMapperConverter converter) {
		return new AuditModelMappingContextConverter(converter);
	}

	@Bean
	public CodeModelDTOMapperConverter codeModelDTOMapperConverter() {
		return new CodeModelDTOMapperConverter();
	}

	@Bean
	public CodeModelDTOMappingContextConverter codeModelDTOMappingContextConverter(
			@Qualifier("codeModelDTOMapperConverter") @NotNull final CodeModelDTOMapperConverter converter) {
		return new CodeModelDTOMappingContextConverter(converter);
	}

	@Bean
	public CodeModelMapperConverter codeModelapperConverter() {
		return new CodeModelMapperConverter();
	}

	@Bean
	public CodeModelMappingContextConverter codeModelMappingContextConverter(
			@Qualifier("codeModelapperConverter") @NotNull final CodeModelMapperConverter converter) {
		return new CodeModelMappingContextConverter(converter);
	}

	@Bean
	public DescriptionModelDTOMapperConverter descriptionModelDTOMapperConverter() {
		return new DescriptionModelDTOMapperConverter();
	}

	@Bean
	public DescriptionModelDTOMappingContextConverter descriptionModelDTOMappingContextConverter(
			@Qualifier("descriptionModelDTOMapperConverter") @NotNull final DescriptionModelDTOMapperConverter converter) {
		return new DescriptionModelDTOMappingContextConverter(converter);
	}

	@Bean
	public DescriptionModelMapperConverter descriptionModelMapperConverter() {
		return new DescriptionModelMapperConverter();
	}

	@Bean
	public DescriptionModelMappingContextConverter descriptionModelMappingContextConverter(
			@Qualifier("descriptionModelMapperConverter") @NotNull final DescriptionModelMapperConverter converter) {
		return new DescriptionModelMappingContextConverter(converter);
	}

	@Bean
	public LocalizedModelDTOMapperConverter localizedModelDTOMapperConverter() {
		return new LocalizedModelDTOMapperConverter();
	}

	@Bean
	public LocalizedModelDTOMappingContextConverter localizedModelDTOMappingContextConverter(
			@Qualifier("localizedModelDTOMapperConverter") @NotNull final LocalizedModelDTOMapperConverter converter) {
		return new LocalizedModelDTOMappingContextConverter(converter);
	}

	@Bean
	public LocalizedModelMapperConverter localizedModelMapperConverter() {
		return new LocalizedModelMapperConverter();
	}

	@Bean
	public LocalizedModelMappingContextConverter localizedModelMappingContextConverter(
			@Qualifier("localizedModelMapperConverter") @NotNull final LocalizedModelMapperConverter converter) {
		return new LocalizedModelMappingContextConverter(converter);
	}

	@Bean
	public NameModelDTOMapperConverter nameModelDTOMapperConverter() {
		return new NameModelDTOMapperConverter();
	}

	@Bean
	public NameModelDTOMappingContextConverter nameModelDTOMappingContextConverter(
			@Qualifier("nameModelDTOMapperConverter") @NotNull final NameModelDTOMapperConverter converter) {
		return new NameModelDTOMappingContextConverter(converter);
	}

	@Bean
	public NameModelMapperConverter nameModelMapperConverter() {
		return new NameModelMapperConverter();
	}

	@Bean
	public NameModelMappingContextConverter nameModelMappingContextConverter(
			@Qualifier("nameModelMapperConverter") @NotNull final NameModelMapperConverter converter) {
		return new NameModelMappingContextConverter(converter);
	}

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@Bean(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper commonModelMapper(
			@Qualifier("auditModelDTOMappingContextConverter") @NotNull final AuditModelDTOMappingContextConverter auditModelDTOMappingContextConverter,
			@Qualifier("codeModelDTOMappingContextConverter") @NotNull final CodeModelDTOMappingContextConverter codeModelDTOMappingContextConverter,
			@Qualifier("descriptionModelDTOMappingContextConverter") @NotNull final DescriptionModelDTOMappingContextConverter descriptionModelDTOMappingContextConverter,
			@Qualifier("localizedModelDTOMappingContextConverter") @NotNull final LocalizedModelDTOMappingContextConverter localizedModelDTOMappingContextConverter,
			@Qualifier("nameModelDTOMappingContextConverter") @NotNull final NameModelDTOMappingContextConverter nameModelDTOMappingContextConverter,
			@Qualifier("auditModelMappingContextConverter") @NotNull final AuditModelMappingContextConverter auditModelMappingContextConverter,
			@Qualifier("codeModelMappingContextConverter") @NotNull final CodeModelMappingContextConverter codeModelMappingContextConverter,
			@Qualifier("descriptionModelMappingContextConverter") @NotNull final DescriptionModelMappingContextConverter descriptionModelMappingContextConverter,
			@Qualifier("localizedModelMappingContextConverter") @NotNull final LocalizedModelMappingContextConverter localizedModelMappingContextConverter,
			@Qualifier("nameModelMappingContextConverter") @NotNull final NameModelMappingContextConverter nameModelMappingContextConverter) {
		final ModelMapper mapper = new ModelMapper();

		// DTO converters
		mapper.addConverter(auditModelDTOMappingContextConverter, AuditModel.class, AuditModelDTO.class);
		mapper.addConverter(codeModelDTOMappingContextConverter, CodeModel.class, CodeModelDTO.class);
		mapper.addConverter(descriptionModelDTOMappingContextConverter, DescriptionModel.class,
				DescriptionModelDTO.class);
		mapper.addConverter(localizedModelDTOMappingContextConverter, LocalizedModel.class, LocalizedModelDTO.class);
		mapper.addConverter(nameModelDTOMappingContextConverter, NameModel.class, NameModelDTO.class);

		// Model converters
		mapper.addConverter(auditModelMappingContextConverter, AuditModelDTO.class, AuditModel.class);
		mapper.addConverter(codeModelMappingContextConverter, CodeModelDTO.class, CodeModel.class);
		mapper.addConverter(descriptionModelMappingContextConverter, DescriptionModelDTO.class, DescriptionModel.class);
		mapper.addConverter(localizedModelMappingContextConverter, LocalizedModelDTO.class, LocalizedModel.class);
		mapper.addConverter(nameModelMappingContextConverter, NameModelDTO.class, NameModel.class);

		return mapper;
	}
}
