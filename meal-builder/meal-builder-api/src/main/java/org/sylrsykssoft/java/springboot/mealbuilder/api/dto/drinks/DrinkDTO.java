/**
 * DrinkDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks.DrinkI18nMessages.DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.FoodSizeI18nMessages.FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.drinks.DrinkJsonProperties.DRINK_MODEL_TYPE_JSON_PROPERTY;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.FoodSizeJsonProperties.FOOD_SIZE_MODEL_SIZE_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.PriceDataJsonProperties.PRICE_DATA_MODEL_PRICE_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nStartEndDateModelMessages.START_END_DATE_MODEL_STARTENDDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonAuditModelProperties.AUDIT_MODEL_AUDIT_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonLocalizedModelProperties.LOCALIZED_MODEL_LOCALIZATIONS_DATA_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonStartEndDateModelProperties.START_END_DATE_MODEL_START_DATE_JSON_OBJECT_PROPERTY;

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
import org.sylrsykssoft.springboot.common.api.json.deserializer.embeddable.MapLocalizationsDataKeyDeseralizer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "DrinkDTO", description = "Model DrinkDTO")
public class DrinkDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = -7969741388969178253L;

	@NotNull(message = DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = DRINK_MODEL_TYPE_JSON_PROPERTY, required = true)
	@Schema(name = DRINK_MODEL_TYPE_JSON_PROPERTY, description = "Type DrinkType", required = true)
	@Builder.Default
	DrinkType type = DrinkType.NO_ALCOHOLIC;

	@NotNull(message = FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = FOOD_SIZE_MODEL_SIZE_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = FOOD_SIZE_MODEL_SIZE_JSON_OBJECT_PROPERTY, description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;

	@NotNull(message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = PRICE_DATA_MODEL_PRICE_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = PRICE_DATA_MODEL_PRICE_JSON_OBJECT_PROPERTY, description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;

	@NotNull(message = START_END_DATE_MODEL_STARTENDDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = START_END_DATE_MODEL_START_DATE_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = START_END_DATE_MODEL_START_DATE_JSON_OBJECT_PROPERTY, description = "DrinkStartEndDateData StartEndDateModelDTO", required = true)
	StartEndDateModelDTO drinkStartEndDateData;

	@JsonProperty(value = LOCALIZED_MODEL_LOCALIZATIONS_DATA_JSON_OBJECT_PROPERTY)
	@JsonDeserialize(keyUsing = MapLocalizationsDataKeyDeseralizer.class)
	@JsonManagedReference
	@Schema(name = LOCALIZED_MODEL_LOCALIZATIONS_DATA_JSON_OBJECT_PROPERTY, description = "Localizations of the name of DrinkDTO")
	@Builder.Default
	@EqualsAndHashCode.Exclude
	transient Map<LocalizedFieldNameModelDTO, LocalizedDrinkDTO> localizationsData = new HashMap<>();

	@Schema(name = AUDIT_MODEL_AUDIT_JSON_OBJECT_PROPERTY, description = "DrinkCreationData AuditModelDTO")
	@JsonIgnore
	AuditModelDTO drinkCreationData;

}
