/**
 * CommonModelMapperMappingContextConverterConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.common;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.AuditModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.CodeModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.DescriptionModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedFieldNameModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.LocalizedValueModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.NameModelDTOMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.AuditModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.CodeModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.DescriptionModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedFieldNameModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedValueModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.NameModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.AuditModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.CodeModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.DescriptionModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedFieldNameModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.LocalizedValueModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.NameModelMappingContextConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.AuditModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.CodeModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.DescriptionModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedFieldNameModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedValueModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.NameModelMapperConverter;

/**
 * Model mapper configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class CommonModelMapperMappingContextConverterConfiguration {

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
	public LocalizedFieldNameModelDTOMapperConverter localizedFieldNameModelDTOMapperConverter() {
		return new LocalizedFieldNameModelDTOMapperConverter();
	}

	@Bean
	public LocalizedFieldNameModelDTOMappingContextConverter localizedFieldNameModelDTOMappingContextConverter(
			@Qualifier("localizedFieldNameModelDTOMapperConverter") @NotNull final LocalizedFieldNameModelDTOMapperConverter converter) {
		return new LocalizedFieldNameModelDTOMappingContextConverter(converter);
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
	public LocalizedFieldNameModelMapperConverter localizedFieldNameModelMapperConverter() {
		return new LocalizedFieldNameModelMapperConverter();
	}

	@Bean
	public LocalizedFieldNameModelMappingContextConverter localizedFieldNameModelMappingContextConverter(
			@Qualifier("localizedFieldNameModelMapperConverter") @NotNull final LocalizedFieldNameModelMapperConverter converter) {
		return new LocalizedFieldNameModelMappingContextConverter(converter);
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
	public LocalizedValueModelDTOMapperConverter localizedValueModelDTOMapperConverter() {
		return new LocalizedValueModelDTOMapperConverter();
	}

	@Bean
	public LocalizedValueModelDTOMappingContextConverter localizedValueModelDTOMappingContextConverter(
			@Qualifier("localizedValueModelDTOMapperConverter") @NotNull final LocalizedValueModelDTOMapperConverter converter) {
		return new LocalizedValueModelDTOMappingContextConverter(converter);
	}

	@Bean
	public LocalizedValueModelMapperConverter localizedValueModelMapperConverter() {
		return new LocalizedValueModelMapperConverter();
	}

	@Bean
	public LocalizedValueModelMappingContextConverter localizedValueModelMappingContextConverter(
			@Qualifier("localizedValueModelMapperConverter") @NotNull final LocalizedValueModelMapperConverter converter) {
		return new LocalizedValueModelMappingContextConverter(converter);
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
}
