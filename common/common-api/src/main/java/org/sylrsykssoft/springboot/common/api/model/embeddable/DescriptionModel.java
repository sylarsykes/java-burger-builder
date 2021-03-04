/**
 * DescriptionModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.DESCRIPTION_FIELD_COLUMN_DEFINITION;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_DESCRIPTION;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_DESCRIPTION_COLUMN;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Embeddable description model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class DescriptionModel {

	@Column(name = BASE_NAME_MODEL_NAME_DESCRIPTION_COLUMN, nullable = true, columnDefinition = DESCRIPTION_FIELD_COLUMN_DEFINITION, length = MAX_LENGTH_DESCRIPTION)
	@Size(max = MAX_LENGTH_DESCRIPTION)
	String description;
	
}
