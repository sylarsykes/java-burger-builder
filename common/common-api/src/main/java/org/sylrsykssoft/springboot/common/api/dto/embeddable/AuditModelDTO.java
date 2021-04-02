/**
 * AuditModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_CREATED_DATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_LAST_MODIFIED_BY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonAuditModelProperties.AUDIT_MODEL_CREATE_BY_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonAuditModelProperties.AUDIT_MODEL_CREATE_DATE_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonAuditModelProperties.AUDIT_MODEL_LAST_MODIFIED_BY_JSON_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonAuditModelProperties.AUDIT_MODEL_LAST_MODIFIED_DATE_JSON_PROPERTY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Embeddable audit model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class AuditModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = -8640731493307745895L;

	@NotBlank(message = AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER, message = AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@JsonProperty(value = AUDIT_MODEL_CREATE_BY_JSON_PROPERTY, required = true)
	String createdBy;

	@NotNull(message = AUDIT_MODEL_CREATED_DATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = AUDIT_MODEL_CREATE_DATE_JSON_PROPERTY, required = true)
	LocalDateTime createdDate;

	@Nullable
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER, message = AUDIT_MODEL_LAST_MODIFIED_BY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@JsonProperty(value = AUDIT_MODEL_LAST_MODIFIED_BY_JSON_PROPERTY)
	String lastModifiedBy;

	@Nullable
	@JsonProperty(value = AUDIT_MODEL_LAST_MODIFIED_DATE_JSON_PROPERTY)
	LocalDateTime lastModifiedDate;

}
