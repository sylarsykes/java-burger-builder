/**
 * AuditModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_CREATED_BY_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN_DEFAULT_VALUE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN_DEFAULT_VALUE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_CREATED_DATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nAuditModelMessages.AUDIT_MODEL_LAST_MODIFIED_BY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Embeddable audit model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Embeddable
public class AuditModel extends BaseEmbeddable {

	@Column(name = BASE_AUDIT_MODEL_NAME_CREATED_BY_COLUMN, nullable = false, insertable = true, updatable = false, length = MAX_LENGTH_NICKNAME_USER)
	@NotBlank(message = AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER, message = AUDIT_MODEL_CREATEBY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@CreatedBy
	String createdBy;

	@Column(name = BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN, columnDefinition = BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN_DEFAULT_VALUE, nullable = false, insertable = true, updatable = false)
	@NotNull(message = AUDIT_MODEL_CREATED_DATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@CreatedDate
	LocalDateTime createdDate;

	@Column(name = BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_COLUMN, nullable = true, insertable = false, updatable = true, length = MAX_LENGTH_NICKNAME_USER)
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER, message = AUDIT_MODEL_LAST_MODIFIED_BY_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	@LastModifiedBy
	String lastModifiedBy;

	@Column(name = BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN, columnDefinition = BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN_DEFAULT_VALUE, nullable = true, insertable = false, updatable = true)
	@Nullable
	@LastModifiedDate
	LocalDateTime lastModifiedDate;

}
