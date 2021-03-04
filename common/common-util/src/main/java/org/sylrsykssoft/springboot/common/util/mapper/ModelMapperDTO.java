/**
 * ModelMapperDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.util.mapper;

import java.io.Serializable;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@Builder
public class ModelMapperDTO<R>  implements Serializable {

	private static final long serialVersionUID = 56641465534776921L;
	
	@NonNull
	Class<R> targetClass;
	
}
