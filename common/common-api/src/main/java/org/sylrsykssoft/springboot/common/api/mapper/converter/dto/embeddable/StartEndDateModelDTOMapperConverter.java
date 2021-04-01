/**
 * StartEndDateModelDTOMapperConverter.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

/**
 * StartEndDateModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class StartEndDateModelDTOMapperConverter implements Converter<StartEndDateModel, StartEndDateModelDTO> {

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public StartEndDateModelDTO convert(@NotNull @Valid final StartEndDateModel source) {
		return StartEndDateModelDTO.builder().startDate(source.getStartDate()).endDate(source.getEndDate()).build();
	}

}
