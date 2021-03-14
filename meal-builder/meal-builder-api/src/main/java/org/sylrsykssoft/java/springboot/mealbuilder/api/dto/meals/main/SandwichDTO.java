/**
 * SandwichDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.main;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PreparationDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.embeddable.MealTypeDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * SandwichDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "SandwichDTO", description = "Model SandwichDTO")
public class SandwichDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = 2408070842095365290L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "MealType", required = true)
	@Schema(name = "MealType", description = "MealType of Sandwich", required = true)
	MealTypeDataDTO type;
	
	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Sandwich", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "FoodSize", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	
	@NotNull(message = "SandwichCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "SandwichCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO sandwichCreationData;
	
}
