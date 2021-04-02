/**
 * FoodSizeDataDTO.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.FoodSizeJsonProperties.FOOD_SIZE_MODEL_SIZE_JSON_PROPERTY;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FoodSize;
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
 * FoodSizeDataDTO
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
@Schema(name = "FoodSizeDataDTO", description = "Model FoodSizeDataDTO")
public class FoodSizeDataDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 2876418255242892482L;

	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = FOOD_SIZE_MODEL_SIZE_JSON_PROPERTY, required = true)
	@Schema(name = FOOD_SIZE_MODEL_SIZE_JSON_PROPERTY, description = "Size", required = true)
	FoodSize size;

}
