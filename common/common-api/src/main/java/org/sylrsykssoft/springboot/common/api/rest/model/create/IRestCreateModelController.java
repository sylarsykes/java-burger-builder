/**
 * IRestCreateModelController.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.rest.model.create;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;
import org.sylrsykssoft.springboot.common.api.service.model.create.dto.CreateModelDTO;
import org.sylrsykssoft.springboot.common.api.service.model.create.helper.CreateModelHelperService;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IRestCreateModelController<S extends CreateModelDTO<D, N>, D extends BaseNameModelDTO<N>, E extends BaseModel<N>, N extends Number> {

	
	/**
	 * Get main model service class.
	 * 
	 * @return ModelService<D, E, N>
	 */
	CreateModelHelperService<S, D, E, N> getHelperModelService();
	
}
