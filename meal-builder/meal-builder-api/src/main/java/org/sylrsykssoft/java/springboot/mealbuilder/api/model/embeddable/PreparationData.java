/**
 * MealPreparationData.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.PREPARATION_PREPARATION_NAME_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.DESCRIPTION_FIELD_COLUMN_DEFINITION;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_DESCRIPTION;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_DESCRIPTION;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Preparation
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
public class PreparationData {

	@Column(name = PREPARATION_PREPARATION_NAME_COLUMN, nullable = false, columnDefinition = DESCRIPTION_FIELD_COLUMN_DEFINITION, length = MAX_LENGTH_DESCRIPTION)
	@NotBlank(message = "Prepatation field is mandatory")
	@Size(min = MIN_LENGTH_DESCRIPTION, max = MAX_LENGTH_DESCRIPTION)
	String preparation;
}
