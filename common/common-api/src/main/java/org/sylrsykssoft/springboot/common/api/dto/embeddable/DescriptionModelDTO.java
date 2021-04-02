/**
 * DescriptionModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_DESCRIPTION;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nDescriptionModelMessages.DESCRIPTION_MODEL_DESCRIPTION_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonDescriptionModelProperties.DESCRIPTION_MODEL_DESCRIPTION_JSON_PROPERTY;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

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
 * Embeddable description model
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
public class DescriptionModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = 1721699098779609535L;

	@Nullable
	@Size(max = MAX_LENGTH_DESCRIPTION, message = DESCRIPTION_MODEL_DESCRIPTION_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@JsonProperty(value = DESCRIPTION_MODEL_DESCRIPTION_JSON_PROPERTY, required = false)
	String description;

}
