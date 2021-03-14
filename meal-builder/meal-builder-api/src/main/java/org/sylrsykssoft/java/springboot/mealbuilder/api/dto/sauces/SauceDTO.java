/**
 * SauceDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.sauces;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PreparationDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * SauceDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "SauceDTO", description = "Model SauceDTO")
public class SauceDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = -4159232686493712204L;

	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Cocktail", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "Size", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "SauceIngredients field is mandatory")
	@JsonProperty(value = "Ingredients", required = true)
	@JsonManagedReference
	@Schema(name = "SauceIngredients", description = "Ingredients of Sauce", required = true)
	@Singular
	transient Set<SauceIngredientDTO> sauceIngredients;
	
	@NotNull(message = "DrinkCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "DrinkCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO drinkCreationData;
	
}
