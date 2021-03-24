/**
 * DrinkDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DrinkType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Drink DTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "DrinkDTO", description = "Model DrinkDTO")
public class DrinkDTO extends BaseNameModelDTO<Long> implements Serializable {
	
	private static final long serialVersionUID = -7969741388969178253L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "Type", required = true)
	@Schema(name = "DrinkType", description = "Type DrinkType", required = true)
	@Builder.Default
	DrinkType type = DrinkType.NO_ALCOHOLIC;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "Size", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@JsonProperty(value = "LocalizationsName", required = true)
	@JsonManagedReference
	@Schema(name = "LocalizedNameDrinkDTO", description = "Localizations of the name of DrinkDTO", required = true)
	@Builder.Default
	transient Map<String, LocalizedNameDrinkDTO> localizationsName = new HashMap<>();
	
	@JsonProperty(value = "LocalizationsDescription", required = true)
	@JsonManagedReference
	@Schema(name = "LocalizedDescriptionDrinkDTO", description = "Localizations of the description of DrinkDTO", required = true)
	@Builder.Default
	transient Map<String, LocalizedDescriptionDrinkDTO> localizationsDescription = new HashMap<>();
	
	@NotNull(message = "DrinkCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "DrinkCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO drinkCreationData;
	
}
