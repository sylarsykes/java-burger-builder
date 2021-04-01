/**
 * StartEndDateModelMapperConverter.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

/**
 * StartEndDateModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class StartEndDateModelMapperConverter implements Converter<StartEndDateModelDTO, StartEndDateModel> {

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public StartEndDateModel convert(@NotNull @Valid final StartEndDateModelDTO source) {
		return StartEndDateModel.builder().startDate(source.getStartDate()).endDate(source.getEndDate()).build();
	}

}
