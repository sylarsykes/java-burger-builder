/**
 * BaseLocalizationDataModelDTO.java 4 abr. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.create.dto;

import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_EMBEDDED_ID_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_VALUE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonBaseModelProperties.BASE_MODEL_EMBEDDED_ID_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonLocalizedModelProperties.LOCALIZED_MODEL_VALUE_JSON_OBJECT_PROPERTY;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.springboot.common.api.dto.BaseModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * BaseLocalizationDataModelDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseLocalizationDataModelDTO<N extends Number> extends BaseModelDTO<N> {

	@NotNull(message = LOCALIZED_MODEL_EMBEDDED_ID_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = BASE_MODEL_EMBEDDED_ID_JSON_PROPERTY, required = true)
	LocalizedFieldNameModelDTO embeddedId;

	@NotNull(message = LOCALIZED_MODEL_VALUE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = LOCALIZED_MODEL_VALUE_JSON_OBJECT_PROPERTY, required = true)
	LocalizedValueModelDTO value;

}
