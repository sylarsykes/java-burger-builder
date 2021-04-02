/**
 * BaseCodeModelDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;


import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nCodeModelMessages.CODE_MODEL_CODE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonCodeModelProperties.CODE_MODEL_NAME_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonDescriptionModelProperties.DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * Base class for DTOs
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @param <N> Class type than extends of Number
 */
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class BaseCodeModelDTO<N extends Number> extends BaseModelDTO<N> {

	@NotNull(message = CODE_MODEL_CODE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = CODE_MODEL_NAME_JSON_OBJECT_PROPERTY, required = true)
	CodeModelDTO code;

	@Nullable
	@JsonProperty(value = DESCRIPTION_MODEL_DESCRIPTION_JSON_OBJECT_PROPERTY)
	DescriptionModelDTO description;

	@JsonIgnore
	AuditModelDTO auditData;

}
