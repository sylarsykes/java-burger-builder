/**
 * PriceDataDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_DIGITS_PRECISION_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_DIGITS_SCALE_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_DIGITS_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_POSITIVE_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.PriceDataJsonProperties.PRICE_DATA_MODEL_PRICE_JSON_PROPERTY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

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
 * PriceDataDTO
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
@Schema(name = "PriceDataDTO", description = "Model PriceDataDTO")
public class PriceDataDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 6566937445829466200L;

	@NotNull(message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@Positive(message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_POSITIVE_MESSAGE)
	@Digits(integer = LENGTH_DIGITS_PRECISION_PRICE, fraction = LENGTH_DIGITS_SCALE_PRICE, message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_DIGITS_MESSAGE)
	@JsonProperty(value = PRICE_DATA_MODEL_PRICE_JSON_PROPERTY, required = true)
	@Schema(name = PRICE_DATA_MODEL_PRICE_JSON_PROPERTY, description = "Price", required = true)
	BigDecimal price;

}
