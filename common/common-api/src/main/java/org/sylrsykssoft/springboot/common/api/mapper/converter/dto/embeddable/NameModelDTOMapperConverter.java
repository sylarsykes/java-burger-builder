/**
 * NameModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

/**
 * NameModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class NameModelDTOMapperConverter implements Converter<NameModel, NameModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public NameModelDTO convert(@NotNull @Valid final NameModel source) {
		return NameModelDTO.builder().name(source.getName()).build();
	}
}
