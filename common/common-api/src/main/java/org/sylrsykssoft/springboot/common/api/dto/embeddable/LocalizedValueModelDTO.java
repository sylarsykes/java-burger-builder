/**
 * LocalizedValueModelDTO.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_VALUE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_VALUE;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Embeddable description model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class LocalizedValueModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = 1721699098779609535L;
	
	@NotBlank(message = "Value field is mandatory")
	@Size(min = MIN_LENGTH_LOCALIZED_VALUE, max = MAX_LENGTH_LOCALIZED_VALUE)
	@JsonProperty(value = "Value", required = false)
	String value;
	
}
