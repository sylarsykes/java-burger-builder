/**
 * CategoryDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals;

import java.io.Serializable;

import org.sylrsykssoft.springboot.common.api.dto.BaseCodeModelDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * CategoryDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "CategoryDTO", description = "Model CategoryDTO")
public class CategoryDTO extends BaseCodeModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = -2352786615809555499L;

}
