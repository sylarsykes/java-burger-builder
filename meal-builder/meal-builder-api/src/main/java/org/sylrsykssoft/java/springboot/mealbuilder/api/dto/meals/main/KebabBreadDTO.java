/**
 * BurgerBreadDTO.java 14 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.main;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.BreadDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * BurgerBreadDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "BurgerBreadDTO", description = "Model BurgerBreadDTO")
public class KebabBreadDTO extends BaseNameModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = -2944091367904463284L;
	
	@NotNull(message = "Bread field is mandatory")
	@JsonProperty(value = "BreadData", required = true)
	@Schema(name = "BreadData", description = "Size FoodSize", required = true)
	BreadDataDTO bread;
	
}
