/**
 * CreateModelService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.create;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;
import org.sylrsykssoft.springboot.common.api.service.model.ModelService;

import lombok.NonNull;

/**
 * CreateModelService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface CreateModelService<D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> extends ModelService<D, E, N> {

	/**
	 * Saves a dto.
	 *
	 * @param dto
	 * @return the saved dto
	 */
	D save(@NonNull @NotNull @Valid D dto);
	
}
