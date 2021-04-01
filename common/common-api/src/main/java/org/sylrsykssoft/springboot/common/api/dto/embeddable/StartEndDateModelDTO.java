/**
 * StartEndDateModelDTO.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * StartEndDateModelDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class StartEndDateModelDTO extends BaseEmbeddableDTO implements Serializable {

	private static final long serialVersionUID = -1631463981404407319L;

	@NotNull(message = "StartDate field is mandatory")
	@JsonProperty(value = "StartDate", required = true)
	LocalDateTime startDate;
	
	@Nullable
	@JsonProperty(value = "EndDate")
	LocalDateTime endDate;
	
}
