/**
 * MealPrice.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_DIGITS_PRECISION_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_DIGITS_SCALE_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_PRECISION_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_SCALE_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.PRICE_PRICE_NAME_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_DIGITS_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_POSITIVE_MESSAGE;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Price
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Embeddable
public class PriceData {

	@Column(name = PRICE_PRICE_NAME_COLUMN, nullable = false, precision = LENGTH_PRECISION_PRICE, scale = LENGTH_SCALE_PRICE)
	@NotNull(message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@Positive(message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_POSITIVE_MESSAGE)
	@Digits(integer = LENGTH_DIGITS_PRECISION_PRICE, fraction = LENGTH_DIGITS_SCALE_PRICE, message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_DIGITS_MESSAGE)
	BigDecimal price;
	
}
