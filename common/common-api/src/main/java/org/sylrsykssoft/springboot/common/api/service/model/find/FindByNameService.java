/**
 * FindByNameService.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.find;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;

import lombok.NonNull;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface FindByNameService<D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> extends FindByService<D, E, N> {

	/**
	 * Retrieves an entity by its name.
	 *
	 * @param name must not be {@literal null}.
	 * @return the entity with the given name.
	 * @throws IllegalArgumentException if {@literal name} is {@literal null}.
	 * @throws EntityNotFoundException if entity not exists.
	 */
	D findByName(@NonNull @NotBlank String name) throws IllegalArgumentException, EntityNotFoundException;
	
}
