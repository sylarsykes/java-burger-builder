/**
 * CreateDrinkModelDTO.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOODSIZE_SIZE_JSON_ALLOWED_VALUES_LARGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOODSIZE_SIZE_JSON_ALLOWED_VALUES_MEDIUM;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOODSIZE_SIZE_JSON_ALLOWED_VALUES_SMALL;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOODSIZE_SIZE_JSON_DEFAULT_VALUE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINK_TYPE_JSON_ALLOWED_VALUES_ALCOHOLIC;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINK_TYPE_JSON_ALLOWED_VALUES_NO_ALCOHOLIC;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINK_TYPE_JSON_DEFAULT_VALUE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks.CreateDrinkI18nMessages.CREATE_DRINK_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks.CreateDrinkI18nMessages.CREATE_DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.FoodSizeI18nMessages.FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.drinks.DrinkJsonProperties.DRINK_MODEL_TYPE_JSON_PROPERTY;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.FoodSizeJsonProperties.FOOD_SIZE_MODEL_SIZE_JSON_PROPERTY;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.PriceDataJsonProperties.PRICE_DATA_MODEL_PRICE_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nNameModelMessages.NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nStartEndDateModelMessages.START_END_DATE_MODEL_STARTENDDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonDescriptionModelProperties.DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonNameModelProperties.NAME_MODEL_NAME_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonStartEndDateModelProperties.START_END_DATE_MODEL_START_DATE_JSON_OBJECT_PROPERTY;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;
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

	@NotNull(message = NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = NAME_MODEL_NAME_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = NAME_MODEL_NAME_JSON_OBJECT_PROPERTY, description = "Name value", required = true)
	NameModelDTO name;

	@Nullable
	@JsonProperty(value = DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY)
	@Schema(name = DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY, description = "Description value", nullable = true)
	DescriptionModelDTO description;

	@NotBlank(message = CREATE_DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@JsonProperty(value = DRINK_MODEL_TYPE_JSON_PROPERTY, required = true, defaultValue = DRINK_TYPE_JSON_DEFAULT_VALUE)
	@Schema(name = DRINK_MODEL_TYPE_JSON_PROPERTY, description = "Type DrinkType", required = true, allowableValues = {
			DRINK_TYPE_JSON_ALLOWED_VALUES_NO_ALCOHOLIC,
			DRINK_TYPE_JSON_ALLOWED_VALUES_ALCOHOLIC }, defaultValue = DRINK_TYPE_JSON_DEFAULT_VALUE)
	String type;

	@NotBlank(message = FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = FOOD_SIZE_MODEL_SIZE_JSON_PROPERTY, required = true, defaultValue = FOODSIZE_SIZE_JSON_DEFAULT_VALUE)
	@Schema(name = FOOD_SIZE_MODEL_SIZE_JSON_PROPERTY, description = "Size FoodSize", required = true, allowableValues = {
			FOODSIZE_SIZE_JSON_ALLOWED_VALUES_SMALL, FOODSIZE_SIZE_JSON_ALLOWED_VALUES_MEDIUM,
			FOODSIZE_SIZE_JSON_ALLOWED_VALUES_LARGE }, defaultValue = FOODSIZE_SIZE_JSON_DEFAULT_VALUE)
	String size;

	@NotNull(message = CREATE_DRINK_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = PRICE_DATA_MODEL_PRICE_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = PRICE_DATA_MODEL_PRICE_JSON_OBJECT_PROPERTY, description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;

	@NotNull(message = START_END_DATE_MODEL_STARTENDDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = START_END_DATE_MODEL_START_DATE_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = START_END_DATE_MODEL_START_DATE_JSON_OBJECT_PROPERTY, description = "DrinkStartEndDateData StartEndDateModelDTO", required = true)
	StartEndDateModelDTO drinkStartEndDateData;

}
