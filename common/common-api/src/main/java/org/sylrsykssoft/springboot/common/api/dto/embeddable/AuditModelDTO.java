/**
 * AuditModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NICKNAME_USER;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
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
public class AuditModelDTO {

	@NonNull
	@NotBlank(message = "CreatedBy field is mandatory")
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER)
	@JsonProperty(value = "CreatedBy", required = true)
	String createdBy;

	@NonNull
	@NotNull(message = "CreatedDate field is mandatory")
	@JsonProperty(value = "CreatedDate", required = true)
	LocalDateTime createdDate;

	@Nullable
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER)
	@JsonProperty(value = "LastModifiedBy")
	String lastModifiedBy;

	@Nullable
	@JsonProperty(value = "LastModifiedDate")
	LocalDateTime lastModifiedDate;
	
}
