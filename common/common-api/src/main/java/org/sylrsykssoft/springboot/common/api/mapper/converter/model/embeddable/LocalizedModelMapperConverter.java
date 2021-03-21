/**
 * LocalizedModelMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;

/**
 * LocalizedModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class LocalizedModelMapperConverter implements Converter<LocalizedModelDTO, LocalizedModel> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedModel convert(@NotNull @Valid final LocalizedModelDTO source) {
		return LocalizedModel.builder().id(source.getId()).locale(source.getLocale()).build();
	}
}
