/**
 * FindByNameService.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.find;

import java.util.Locale;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	 * @param locale the locale in which to do the lookup.
	 * @return the entity with the given name.
	 * @throws IllegalArgumentException if {@literal name} is {@literal null}.
	 * @throws EntityNotFoundException if entity not exists.
	 */
	D findByName(@NonNull @NotBlank String name, @NonNull @NotNull Locale locale) throws IllegalArgumentException, EntityNotFoundException;
	
}
