/**
 * SandwichCategoryDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.main;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.CategoryDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseModelDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * SandwichCategoryDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "SandwichCategoryDTO", description = "Model SandwichCategoryDTO")
public class SandwichCategoryDTO extends BaseModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = -799562128665955852L;

	@JsonBackReference
	CategoryDTO category;
	
	@NotNull(message = "CreatedAt field is mandatory")
	@JsonProperty(value = "CreatedAt", required = true)
	@Schema(name = "CreatedAt", description = "Created date of Category", required = true)
	LocalDateTime createdAt;
	
}
