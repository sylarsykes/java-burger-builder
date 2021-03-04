/**
 * NameModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NAME;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Embeddable name model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class NameModel {

	@Column(name = BASE_NAME_MODEL_NAME_NAME_COLUMN, nullable = false, unique = true, length = MAX_LENGTH_NAME)
	@NotBlank(message = "Name field is mandatory")
	@Size(min = MIN_LENGTH_NAME, max = MAX_LENGTH_NAME)
	String name;
	
}
