/**
 * IngredientData.java 28 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_COUNT_NAME_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_CREATED_AT_NAME_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_POSITION_NAME_COLUMN;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * IngredientData
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Embeddable
public class IngredientData {

	@Column(name = INGREDIENT_COUNT_NAME_COLUMN, nullable = false)
	@NotBlank(message = "Count field is mandatory")
	String count;
	
	@Column(name = INGREDIENT_POSITION_NAME_COLUMN, nullable = false)
	@NotNull(message = "Position field is mandatory")
	@Positive
	Short position;
	
	@Column(name = INGREDIENT_CREATED_AT_NAME_COLUMN, nullable = false)
	@NotNull(message = "CreatedAt field is mandatory")
	LocalDateTime createdAt;
	
}
