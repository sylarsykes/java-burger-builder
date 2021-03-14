/**
 * IngredientDTO.java 10 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.IngredientType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * IngredientDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "IngredientDTO", description = "Model IngredientDTO")
public class IngredientDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = 6224623603699093385L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "Type", required = true)
	@Schema(name = "IngredientType", description = "Type IngredientType", required = true)
	@Builder.Default
	IngredientType type = IngredientType.COCKTAIL;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	@Hidden
	@Singular
	transient Set<CocktailIngredientDTO> cocktailIngredients;
	
	@NotNull(message = "IngredientCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "IngredientCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO ingredientCreationData;
	
}
