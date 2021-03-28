/**
 * IRestController.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.rest.model.find;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;
import org.sylrsykssoft.springboot.common.api.service.model.ModelService;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IRestModelController<D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> {

	/**
	 * Get main model service class.
	 * 
	 * @return ModelService<D, E, N>
	 */
	ModelService<D, E, N> getModelService();
	
}
