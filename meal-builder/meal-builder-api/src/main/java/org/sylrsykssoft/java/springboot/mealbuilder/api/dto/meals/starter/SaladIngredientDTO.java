/**
 * SaladIngredientDTO.java 11 mar. 2021
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
 * SaladIngredientDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "SaladIngredientDTO", description = "Model SaladIngredientDTO")
public class SaladIngredientDTO extends BaseModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = -5913482745275403704L;

	@JsonBackReference
	SaladDTO salad;
	
	@JsonBackReference
	IngredientDTO ingredient;
	
	@NotNull(message = "IngredientData field is mandatory")
	@Schema(name = "IngredientDataDTO", description = "IngredientData IngredientDataDTO", required = true)
	IngredientDataDTO ingredientData;
	
}
