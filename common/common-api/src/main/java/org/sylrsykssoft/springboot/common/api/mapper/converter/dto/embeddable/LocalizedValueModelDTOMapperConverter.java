/**
 * LocalizedValueModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

/**
 * LocalizedValueModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class LocalizedValueModelDTOMapperConverter implements Converter<LocalizedValueModel, LocalizedValueModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedValueModelDTO convert(@NotNull @Valid final LocalizedValueModel source) {
		return LocalizedValueModelDTO.builder().value(source.getValue()).build();
	}
}
