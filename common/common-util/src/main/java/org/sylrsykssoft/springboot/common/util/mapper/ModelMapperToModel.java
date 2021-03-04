/**
 * ModelMapperToDTO.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.util.mapper;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Retention(RUNTIME)
@Target(PARAMETER)
public @interface ModelMapperToModel {
	
	/**
	 * Target Model class.
	 * 
	 * @return Class
	 */
	@SuppressWarnings("rawtypes")
	Class value();
}
