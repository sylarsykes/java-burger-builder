/**
 * CreateDrinkModelDTO.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.service.model.create.dto.CreateModelDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * CreateDrinkModelDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Jacksonized
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "CreateDrinkModelDTO", description = "Model to create DrinkDTO")
public class CreateDrinkModelDTO extends CreateModelDTO<DrinkDTO, Long> implements Serializable {

	private static final long serialVersionUID = -4078145375295487869L;

	@NotNull(message = "CreateDrinkModelDTO::Name field is mandatory")
	@JsonProperty(value = "Name", required = true)
	@Schema(name = "Name", description = "Name value", required = true)
	NameModelDTO name;
	
	@Nullable
	@JsonProperty(value = "Description")
	@Schema(name = "Description", description = "Description value", nullable = true)
	DescriptionModelDTO description;
	
	@NotBlank(message = "CreateDrinkModelDTO::Type field is mandatory")
	@JsonProperty(value = "Type", required = true, defaultValue = "NO_ALCOHOLIC")
	@Schema(name = "Type", description = "Type DrinkType", required = true, allowableValues = { "NO_ALCOHOLIC", "ALCOHOLIC" }, defaultValue = "NO_ALCOHOLIC")
	String type;
	
	@NotBlank(message = "CreateDrinkModelDTO::Size field is mandatory")
	@JsonProperty(value = "Size", required = true, defaultValue = "SMALL")
	@Schema(name = "Size", description = "Size FoodSize", required = true, allowableValues = { "SMALL", "MEDIUM", "LARGE" }, defaultValue = "SMALL")
	String size;
	
	@NotNull(message = "CreateDrinkModelDTO::Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "Price", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
}
