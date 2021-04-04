/**
 * StartEndDateModelDTO.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nStartEndDateModelMessages.START_END_DATE_MODEL_STARTDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonStartEndDateModelProperties.START_END_DATE_MODEL_END_DATE_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonStartEndDateModelProperties.START_END_DATE_MODEL_START_DATE_JSON_PROPERTY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

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
 * StartEndDateModelDTO
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
public class StartEndDateModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = -1631463981404407319L;

	@NotNull(message = START_END_DATE_MODEL_STARTDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = START_END_DATE_MODEL_START_DATE_JSON_PROPERTY, required = true)
	LocalDateTime startDate;

	@Nullable
	@JsonProperty(value = START_END_DATE_MODEL_END_DATE_JSON_PROPERTY)
	LocalDateTime endDate;

}
