/**
 * MealTypeData.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.embeddable;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MealType;
import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * MealType
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class MealTypeDataDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1572838471301626565L;
	
	@NotNull(message = "Type field is mandatory")
	MealType type;
	
}
