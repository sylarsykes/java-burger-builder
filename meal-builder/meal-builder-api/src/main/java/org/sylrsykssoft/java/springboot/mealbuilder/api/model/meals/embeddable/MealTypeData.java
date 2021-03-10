/**
 * MealTypeData.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_TYPE_TYPE_COLUMN_DEFAULT_VALUE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_TYPE_TYPE_COLUMN_LENGTH;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MealType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * MealType
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class MealTypeData {

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = MEAL_TYPE_TYPE_COLUMN_DEFAULT_VALUE, length = MEAL_TYPE_TYPE_COLUMN_LENGTH)
	@NotNull(message = "Type field is mandatory")
	MealType type;
	
}
