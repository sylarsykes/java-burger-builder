/**
 * CreateModelHelperService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.create.helper;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;
import org.sylrsykssoft.springboot.common.api.service.model.ModelService;
import org.sylrsykssoft.springboot.common.api.service.model.create.dto.CreateModelDTO;

import lombok.NonNull;

/**
 * CreateModelHelperService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface CreateModelHelperService<S extends CreateModelDTO<D, N>, D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> {

	/**
	 * Get main model service class.
	 * 
	 * @return ModelService<D, E, N>
	 */
	ModelService<D, E, N> getModelService();
	
	/**
	 * Map entity to model
	 * 
	 * @param source
	 * 		Entity object
	 * 
	 * @return D
	 */
	D mapperToModel(@Valid S source);
	
	/**
	 * Saves a dto.
	 *
	 * @param dto
	 * @return the saved dto
	 */
	D save(@NonNull @NotNull @Valid S dto);
	
}
