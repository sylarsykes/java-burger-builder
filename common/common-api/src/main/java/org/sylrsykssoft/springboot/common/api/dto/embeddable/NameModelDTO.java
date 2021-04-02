/**
 * NameModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NAME;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nNameModelMessages.NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nNameModelMessages.NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonNameModelProperties.NAME_MODEL_NAME_JSON_PROPERTY;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Embeddable name model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Jacksonized
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class NameModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = 2058578079561061396L;

	@NotBlank(message = NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_NAME, max = MAX_LENGTH_NAME, message = NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@JsonProperty(value = NAME_MODEL_NAME_JSON_PROPERTY, required = true)
	String name;

}
