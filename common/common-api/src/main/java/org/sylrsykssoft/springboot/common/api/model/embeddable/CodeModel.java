/**
 * CodeModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_CODE_MODEL_NAME_CODE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_CODE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_CODE;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Embeddable code model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class CodeModel {

	@Column(name = BASE_CODE_MODEL_NAME_CODE_COLUMN, nullable = false, unique = true, length = MAX_LENGTH_CODE)
	@NotBlank(message = "Code field is mandatory")
	@Size(min = MIN_LENGTH_CODE, max = MAX_LENGTH_CODE)
	String code;
	
}
