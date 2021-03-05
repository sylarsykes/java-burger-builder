/**
 * DrinkDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FoodSize;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DrinkType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Drink DTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "DrinkDTO", description = "Model DrinkDTO")
public class DrinkDTO extends BaseNameModelDTO<Long> implements Serializable {
	
	private static final long serialVersionUID = -7969741388969178253L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "DrinkType", required = true)
	@Schema(name = "DrinkType", description = "Type DrinkType", required = true)
	@Builder.Default
	DrinkType type = DrinkType.NO_ALCOHOLIC;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "FoodSize", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	@Builder.Default
	FoodSize size = FoodSize.MEDIUM;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "DrinkCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "DrinkCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO drinkCreationData;
	
}
