/**
 * FindByService.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.find;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;
import org.sylrsykssoft.springboot.common.api.service.model.ModelService;

import lombok.NonNull;

/**
 * FindByService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface FindByService<D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> extends ModelService<D, E, N> {

	/**
	 * Retrieves an entity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id.
	 * @throws IllegalArgumentException if {@literal id} is {@literal null}.
	 * @throws EntityNotFoundException if entity not exists.
	 */
	D findById(@NonNull @NotNull @Positive N id) throws IllegalArgumentException, EntityNotFoundException;
	
	/**
	 * Returns whether an entity with the given id exists.
	 *
	 * @param id must not be {@literal null}.
	 * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
	 * @throws IllegalArgumentException if {@literal id} is {@literal null}.
	 */
	boolean existsById(@NonNull @NotNull @Positive N id) throws IllegalArgumentException;
	
}
