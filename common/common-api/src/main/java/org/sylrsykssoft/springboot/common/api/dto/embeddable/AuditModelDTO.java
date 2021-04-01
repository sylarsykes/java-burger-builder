/**
 * AuditModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NICKNAME_USER;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NICKNAME_USER;

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

	@NotBlank(message = "CreatedBy field is mandatory")
	@Size(min = MIN_LENGTH_NICKNAME_USER, max = MAX_LENGTH_NICKNAME_USER)
	@JsonProperty(value = "CreatedBy", required = true)
	String createdBy;

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
