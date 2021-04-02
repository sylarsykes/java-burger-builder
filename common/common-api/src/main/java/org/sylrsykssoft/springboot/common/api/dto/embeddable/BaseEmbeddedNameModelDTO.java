/**
 * BaseEmbeddedNameModel.java 15 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nNameModelMessages.NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonDescriptionModelProperties.DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonNameModelProperties.NAME_MODEL_NAME_JSON_OBJECT_PROPERTY;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

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
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class BaseEmbeddedNameModelDTO<I extends BaseEmbeddableDTO> extends BaseEmbeddedIdDTO<I> {

	@NotNull(message = NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = NAME_MODEL_NAME_JSON_OBJECT_PROPERTY, required = true)
	NameModelDTO name;

	@Nullable
	@JsonProperty(value = DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY)
	DescriptionModelDTO description;

}
