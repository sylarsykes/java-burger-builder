/**
 * CodeModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_CODE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_CODE;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Embeddable code model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class CodeModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = -4216933576851395499L;
	
	@NotBlank(message = "Code field is mandatory")
	@Size(min = MIN_LENGTH_CODE, max = MAX_LENGTH_CODE)
	@JsonProperty(value = "Code", required = true)
	String code;
	
}
