/**
 * CocktailIngredientDTO.java 9 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.IngredientDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseModelDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "GlassCocktailDTO", description = "Model GlassCocktailDTO")
public class CocktailIngredientDTO extends BaseModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = -1371703639764924998L;

	CocktailDTO cocktail;
	
	IngredientDTO ingredient;
	
	@NotNull(message = "IngredientData field is mandatory")
	@Schema(name = "IngredientDataDTO", description = "IngredientData IngredientDataDTO", required = true)
	IngredientDataDTO ingredientData;
	
}
