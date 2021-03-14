/**
 * FoodSizeDataDTO.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FoodSize;
import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * FoodSizeDataDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class FoodSizeDataDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 2876418255242892482L;
	
	@NotNull(message = "Size field is mandatory")
	FoodSize size;
	
}
