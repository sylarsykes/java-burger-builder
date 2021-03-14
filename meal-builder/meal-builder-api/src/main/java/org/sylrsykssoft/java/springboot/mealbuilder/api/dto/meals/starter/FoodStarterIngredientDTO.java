/**
 * FoodStarterIngredientDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.starter;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.IngredientDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.IngredientDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseModelDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * FoodStarterIngredientDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "FoodStarterIngredientDTO", description = "Model FoodStarterIngredientDTO")
public class FoodStarterIngredientDTO extends BaseModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = 6188291370855701930L;
	
	@JsonBackReference
	FoodStarterDTO foodStarter;
	
	@JsonBackReference
	IngredientDTO ingredient;
	
	@NotNull(message = "IngredientData field is mandatory")
	@Schema(name = "IngredientDataDTO", description = "IngredientData IngredientDataDTO", required = true)
	IngredientDataDTO ingredientData;

}
