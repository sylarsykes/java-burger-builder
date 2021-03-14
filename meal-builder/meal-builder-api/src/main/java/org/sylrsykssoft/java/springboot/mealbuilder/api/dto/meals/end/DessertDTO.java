/**
 * DessertDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.end;

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
 * DessertDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "DessertDTO", description = "Model DessertDTO")
public class DessertDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = -1924277550272585303L;

	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Dessert", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "FoodSize", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "DessertIngredients field is mandatory")
	@JsonProperty(value = "DessertIngredients", required = true)
	@JsonManagedReference
	@Schema(name = "DessertIngredients", description = "Ingredients of Dessert", required = true)
	@Singular
	transient Set<DessertIngredientDTO> dessertIngredients;
	
	@NotNull(message = "DessertCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "DessertCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO dessertCreationData;
	
}
