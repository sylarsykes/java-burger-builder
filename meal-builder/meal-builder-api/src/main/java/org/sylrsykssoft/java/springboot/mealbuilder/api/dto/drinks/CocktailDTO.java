/**
 * CocktailDTO.java 9 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.CocktailClassification;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PreparationDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * CocktailDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "CocktailDTO", description = "Model CocktailDTO")
public class CocktailDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = 8789638332645133881L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "CocktailClassification", required = true)
	@Schema(name = "CocktailClassification", description = "Classification CocktailClassification", required = true)
	@Builder.Default
	CocktailClassification type = CocktailClassification.APPETIZER;
	
	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Cocktail", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "Glass field is mandatory")
	@JsonProperty(value = "GlassCocktail", required = true)
	@JsonManagedReference
	@Schema(name = "GlassCocktail", description = "Glass of Cocktail", required = true)
	GlassCocktailDTO glassCocktail;
	
	@NotNull(message = "CocktailIngredients field is mandatory")
	@JsonProperty(value = "CocktailIngredients", required = true)
	@JsonManagedReference
	@Schema(name = "CocktailIngredients", description = "Ingredients of Cocktail", required = true)
	@Singular
	transient Set<CocktailIngredientDTO> cocktailIngredients;
	
	@NotNull(message = "CocktailCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "CocktailCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO cocktailCreationData;
	
}
