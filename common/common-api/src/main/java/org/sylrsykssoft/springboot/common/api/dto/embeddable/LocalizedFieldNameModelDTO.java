/**
 * LocalizedFieldNameModelDTO.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_FIELD_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_FIELD_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_LOCALE;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Embeddable name model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class LocalizedFieldNameModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = 2058578079561061396L;

	@NotNull(message = "Locale field is mandatory")
	@JsonProperty(value = "Id", required = true)
	Long id;
	
	@NotBlank(message = "Locale field is mandatory")
	@Size(min = MIN_LENGTH_LOCALIZED_LOCALE, max = MAX_LENGTH_LOCALIZED_LOCALE)
	@JsonProperty(value = "Locale", required = true)
	String locale;

	@NotBlank(message = "FieldName field is mandatory")
	@Size(min = MIN_LENGTH_LOCALIZED_FIELD_NAME, max = MAX_LENGTH_LOCALIZED_FIELD_NAME)
	@JsonProperty(value = "FieldName", required = true)
	String fieldName;

}
