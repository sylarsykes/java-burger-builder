/**
 * ErrorTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.error;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.springboot.common.api.builder.BuildableType;
import org.sylrsykssoft.springboot.common.api.builder.ToBuildableType;
import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;
import org.sylrsykssoft.springboot.common.api.dto.error.ErrorTO.ErrorTOBuilderImpl;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Error class.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class ErrorTO extends BaseDTO implements Serializable, ToBuildableType<ErrorTOBuilderImpl, ErrorTO> {

	private static final long serialVersionUID = -4909045121396065176L;

	/** The status code. */
	@NotBlank(message = "StatusCode field is mandatory")
	String statusCode;

	/** The message. */
	@NotBlank(message = "Message field is mandatory")
	String message;

	/** The exception. */
	Throwable exception;

	@NotNull(message = "Time field is mandatory")
	LocalDateTime timestamp;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ErrorTOBuilderImpl toBuilder() {
		return new ErrorTOBuilderImpl();
	}
	
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
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public final ErrorTOBuilderImpl copy(@NonNull @Valid final ErrorTO model) {
			this.$fillValuesFrom(model);
			
			return this;
		}
		
		/**
		 * Create new object
		 * 
		 * @param statusCode
		 * @param message
		 * @param exception
		 * @return ErrorTOBuilderImpl
		 */
		public final ErrorTOBuilderImpl createBy(@NotBlank final String statusCode, @NotBlank final String message, @NotNull final Throwable exception) {
			this.statusCode(statusCode);
			this.message(message);
			this.exception(exception);
			
			return initialize();
		}
		
		/**
		 * Create new object
		 * 
		 * @param statusCode
		 * @param message
		 * @param exception
		 * @return ErrorTOBuilderImpl
		 */
		public final ErrorTOBuilderImpl createBy(@NotBlank final Integer httpStatusValue, @NotBlank final String message, @NotNull final Throwable exception) {
			this.statusCode(httpStatusValue.toString());
			this.message(message);
			this.exception(exception);
			
			return initialize();
		}
	}
}
