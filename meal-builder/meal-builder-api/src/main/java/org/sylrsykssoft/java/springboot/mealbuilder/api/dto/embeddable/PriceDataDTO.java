/**
 * PriceDataDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_DIGITS_PRECISION_PRICE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.LENGTH_DIGITS_SCALE_PRICE;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "PriceDataDTO", description = "Model PriceDataDTO")
public class PriceDataDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 6566937445829466200L;
	
	@NotNull(message = "Price field is mandatory")
	@Positive
	@Digits(integer = LENGTH_DIGITS_PRECISION_PRICE, fraction = LENGTH_DIGITS_SCALE_PRICE)
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "Price", description = "Price", required = true)
	BigDecimal price;
	
}
