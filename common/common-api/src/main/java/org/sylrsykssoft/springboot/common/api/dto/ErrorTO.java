/**
 * BaseErrorDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.springboot.common.api.builder.BuildableType;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Base class for DTOs
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class ErrorTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -4909045121396065176L;

	/** The status code. */
	@NonNull
	@NotBlank(message = "StatusCode field is mandatory")
	String statusCode;

	/** The message. */
	@NonNull
	@NotBlank(message = "Message field is mandatory")
	String message;

	/** The exception. */
	Throwable exception;

	@NonNull
	@NotNull(message = "Time field is mandatory")
	LocalDateTime timestamp;

	
	public static final class ErrorTOBuilderImpl extends ErrorTOBuilder<ErrorTO, ErrorTOBuilderImpl>
		implements BuildableType<ErrorTO, ErrorTOBuilderImpl> {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public final ErrorTOBuilderImpl initialize() {
			this.timestamp(LocalDateTime.now());
			
			return this;
		}
		
		public final ErrorTOBuilderImpl copy(@NonNull @Valid final ErrorTO model) {
			this.$fillValuesFrom(model);
			
			return this;
		}
	}
}
