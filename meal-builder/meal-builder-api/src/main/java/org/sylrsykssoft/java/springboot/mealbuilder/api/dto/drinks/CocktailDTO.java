/**
 * CocktailDTO.java 9 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_INGREDIENT_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_INGREDIENT_MIN_LENGTH;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.CocktailClassification;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PreparationDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
	@JsonProperty(value = "Type", required = true)
	@Schema(name = "Type", description = "Classification CocktailClassification", required = true)
	@Builder.Default
	CocktailClassification type = CocktailClassification.APPETIZER;
	
	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Cocktail", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "Price", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;

	@NotNull(message = "CocktailStartEndDateData field is mandatory")
	@JsonProperty(value = "CocktailStartEndDateData", required = true)
	@Schema(name = "CocktailStartEndDateData", description = "CocktailStartEndDateData StartEndDateModelDTO", required = true)
	StartEndDateModelDTO cocktailStartEndDateData;
	
	@NotNull(message = "Glass field is mandatory")
	@JsonProperty(value = "Glass", required = true)
	@JsonManagedReference
	@Schema(name = "Glass", description = "Glass of Cocktail", required = true)
	GlassCocktailDTO glassCocktail;
	
	@NotNull(message = "CocktailIngredients field is mandatory")
	@Size(min = COCKTAIL_INGREDIENT_MIN_LENGTH, max = COCKTAIL_INGREDIENT_MAX_LENGTH)
	@JsonProperty(value = "Ingredients", required = true)
	@JsonManagedReference
	@Schema(name = "Ingredients", description = "Ingredients of Cocktail", required = true)
	@EqualsAndHashCode.Exclude
	transient Set<CocktailIngredientDTO> cocktailIngredients;
	
	@NotNull(message = "CocktailCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "CocktailCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO cocktailCreationData;
	
}
