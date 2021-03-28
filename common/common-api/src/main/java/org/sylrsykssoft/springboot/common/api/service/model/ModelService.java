package org.sylrsykssoft.springboot.common.api.service.model;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;

public interface ModelService<D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> {

	/**
	 * Get main repository class.
	 * 
	 * @return JpaRepository<E, N>
	 */
	JpaRepository<E, N> getRepository();
	
	/**
	 * Map entity to model
	 * 
	 * @param source
	 * 		Entity object
	 * 
	 * @return D
	 */
	D mapperToModel(@Valid E source);
	
	/**
	 * Map model to entity
	 * 
	 * @param source
	 * 		Model object
	 * 
	 * @return E
	 */
	E mapperToEntity(@Valid D source);
	
}
