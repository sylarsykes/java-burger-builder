/**
 * LocalizedFieldNameModelMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;

/**
 * LocalizedFieldNameModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class LocalizedFieldNameModelMapperConverter
		implements Converter<LocalizedFieldNameModelDTO, LocalizedFieldNameModel> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedFieldNameModel convert(@NotNull @Valid final LocalizedFieldNameModelDTO source) {
		return LocalizedFieldNameModel.builder().id(source.getId()).locale(source.getLocale())
				.fieldName(source.getFieldName()).build();
	}
}
