/**
 * LocalizedValueModelMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

/**
 * LocalizedValueModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class LocalizedValueModelMapperConverter implements Converter<LocalizedValueModelDTO, LocalizedValueModel> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedValueModel convert(@NotNull @Valid final LocalizedValueModelDTO source) {
		return LocalizedValueModel.builder().value(source.getValue()).build();
	}
}
