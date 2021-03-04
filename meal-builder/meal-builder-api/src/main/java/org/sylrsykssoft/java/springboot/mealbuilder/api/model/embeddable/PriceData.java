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

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Price
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class PriceData {

	@Column(name = PRICE_PRICE_NAME_COLUMN, nullable = false, precision = LENGTH_PRECISION_PRICE, scale = LENGTH_SCALE_PRICE)
	@NotNull(message = "Price field is mandatory")
	@Positive
	@Digits(integer = LENGTH_DIGITS_PRECISION_PRICE, fraction = LENGTH_DIGITS_SCALE_PRICE)
	BigDecimal price;
	
}
