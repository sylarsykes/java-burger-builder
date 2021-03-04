/**
 * BuildableType.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.builder;

import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

/**
 * Interface for model builders
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @param <M> Model class type
 * @param <B> Builder class type
 */
public interface BuildableType<M extends BaseDTO, B> {

	/**
	 * Initialize model object
	 * 
	 * @return B
	 */
	B initialize();
	
	/**
	 * Creates a copy (new object) of the model object received as parameter
	 * 
	 * @param model Object model
	 * @return M 
	 */
	B copy(M model);
	
}
