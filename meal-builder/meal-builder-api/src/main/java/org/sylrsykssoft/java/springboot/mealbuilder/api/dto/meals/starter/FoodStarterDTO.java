/**
 * FoodStarterDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.starter;

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
 * FoodStarterDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "FoodStarterDTO", description = "Model FoodStarterDTO")
public class FoodStarterDTO extends BaseNameModelDTO<Long> implements Serializable {
	
	private static final long serialVersionUID = -6551399603948429240L;

	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Cocktail", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "FoodSize", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "FoodStarterIngredients field is mandatory")
	@JsonProperty(value = "FoodStarterIngredients", required = true)
	@JsonManagedReference
	@Schema(name = "FoodStarterIngredients", description = "Ingredients of FoodStarter", required = true)
	@Singular
	transient Set<FoodStarterIngredientDTO> foodStarterIngredients;
	
	@NotNull(message = "FoodStarterCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "FoodStarterCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO foodStarterCreationData;
	
}
