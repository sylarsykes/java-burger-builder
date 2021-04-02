/**
 * LocalizedFieldNameModelDTO.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_FIELD_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_FIELD_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_FIELD_NAME_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_FIELD_NAME_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_ID_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonBaseModelProperties.BASE_MODEL_ID_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonLocalizedModelProperties.LOCALIZED_MODEL_FIELD_NAME_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonLocalizedModelProperties.LOCALIZED_MODEL_LOCALE_JSON_PROPERTY;

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

	@NotNull(message = LOCALIZED_MODEL_ID_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = BASE_MODEL_ID_JSON_PROPERTY, required = true)
	Long id;

	@NotBlank(message = LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_LOCALIZED_LOCALE, max = MAX_LENGTH_LOCALIZED_LOCALE, message = LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@JsonProperty(value = LOCALIZED_MODEL_LOCALE_JSON_PROPERTY, required = true)
	String locale;

	@NotBlank(message = LOCALIZED_MODEL_FIELD_NAME_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_LOCALIZED_FIELD_NAME, max = MAX_LENGTH_LOCALIZED_FIELD_NAME, message = LOCALIZED_MODEL_FIELD_NAME_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@JsonProperty(value = LOCALIZED_MODEL_FIELD_NAME_JSON_PROPERTY, required = true)
	String fieldName;

}
