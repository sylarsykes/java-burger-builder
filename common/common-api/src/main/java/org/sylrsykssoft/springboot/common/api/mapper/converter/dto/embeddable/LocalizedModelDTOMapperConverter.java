/**
 * LocalizedModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;

/**
 * LocalizedModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class LocalizedModelDTOMapperConverter implements Converter<LocalizedModel, LocalizedModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedModelDTO convert(@NotNull @Valid final LocalizedModel source) {
		return LocalizedModelDTO.builder().id(source.getId()).locale(source.getLocale()).build();
	}
}
