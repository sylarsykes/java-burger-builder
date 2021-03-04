/**
 * AuditModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_CREATED_BY_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NICKNAME_USER;

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
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Embeddable audit model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class AuditModel {

	@Column(name = BASE_AUDIT_MODEL_NAME_CREATED_BY_COLUMN, nullable = false, insertable = true, updatable = false, length = MAX_LENGTH_NICKNAME_USER)
	@NotBlank(message = "CreatedBy field is mandatory")
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER)
	@CreatedBy
	String createdBy;

	@Column(name = BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN, nullable = false, insertable = true, updatable = false)
	@NotNull(message = "CreatedDate field is mandatory")
	@CreatedDate
	LocalDateTime createdDate;

	@Column(name = BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_COLUMN, nullable = true, insertable = false, updatable = true, length = MAX_LENGTH_NICKNAME_USER)
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER)
	@LastModifiedBy
	String lastModifiedBy;

	@Column(name = BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN, nullable = true, insertable = false, updatable = true)
	@Nullable
	@LastModifiedDate
	LocalDateTime lastModifiedDate;
	
}
