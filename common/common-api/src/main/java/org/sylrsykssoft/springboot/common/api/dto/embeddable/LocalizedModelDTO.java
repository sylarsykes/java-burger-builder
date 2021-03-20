/**
 * LocalizedModel.java 15 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_LOCALE;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * LocalizedModel
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes
 */
@Value
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class LocalizedModelDTO extends BaseEmbeddableDTO implements Serializable {
	
	private static final long serialVersionUID = -811000266636508172L;

	@NotNull(message = "Locale field is mandatory")
	@JsonProperty(value = "Id", required = true)
	Long id;
	
	@NotBlank(message = "Locale field is mandatory")
	@Size(min = MIN_LENGTH_LOCALIZED_LOCALE, max = MAX_LENGTH_LOCALIZED_LOCALE)
	@JsonProperty(value = "Locale", required = true)
	String locale;
	
}
