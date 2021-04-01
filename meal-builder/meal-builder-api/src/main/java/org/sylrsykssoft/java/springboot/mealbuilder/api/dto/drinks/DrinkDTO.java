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
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;

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
	@Schema(name = "Type", description = "Type DrinkType", required = true)
	@Builder.Default
	DrinkType type = DrinkType.NO_ALCOHOLIC;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "Size", required = true)
	@Schema(name = "Size", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "Price", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "DrinkStartEndDateData field is mandatory")
	@JsonProperty(value = "DrinkStartEndDateData", required = true)
	@Schema(name = "DrinkStartEndDateData", description = "DrinkStartEndDateData StartEndDateModelDTO", required = true)
	StartEndDateModelDTO drinkStartEndDateData;
	
	@JsonProperty(value = "LocalizationsData")
	@JsonManagedReference
	@Schema(name = "LocalizationsData", description = "Localizations of the name of DrinkDTO")
	@Builder.Default
	transient Map<LocalizedFieldNameModelDTO, LocalizedDrinkDTO> localizationsData = new HashMap<>();
	
	@Schema(name = "AuditModelDTO", description = "DrinkCreationData AuditModelDTO")
	@JsonIgnore
	AuditModelDTO drinkCreationData;
	
}
