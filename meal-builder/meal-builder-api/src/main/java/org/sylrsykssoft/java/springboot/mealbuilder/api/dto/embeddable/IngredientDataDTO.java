/**
 * IngredientDataDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

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
public class IngredientDataDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -340223550583797721L;

	@NotBlank(message = "Count field is mandatory")
	String count;
	
	@NotNull(message = "Position field is mandatory")
	@Positive
	Short position;
	
	@NotNull(message = "CreatedAt field is mandatory")
	LocalDateTime createdAt;
	
}
