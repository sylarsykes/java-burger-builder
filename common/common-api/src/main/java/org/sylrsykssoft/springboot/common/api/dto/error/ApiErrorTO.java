/**
 * ApiErrorTO.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.error;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.sylrsykssoft.springboot.common.api.builder.BuildableType;
import org.sylrsykssoft.springboot.common.api.builder.ToBuildableType;
import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;
import org.sylrsykssoft.springboot.common.api.dto.error.ApiErrorTO.ApiErrorTOBuilderImpl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class ApiErrorTO extends BaseDTO implements ToBuildableType<ApiErrorTOBuilderImpl, ApiErrorTO> {
	
	@NotNull(message = "Status field is mandatory")
	@JsonProperty(value = "Status", required = true)
	HttpStatus status;
	
	@NotBlank(message = "Message field is mandatory")
	@JsonProperty(value = "Message", required = true)
	String message;
	
	@Nullable
	@JsonProperty(value = "DebugMessage")
	String debugMessage;
	
	@NotNull(message = "Timestamp field is mandatory")
	@JsonProperty(value = "Timestamp", required = true)
	LocalDateTime timestamp;
	
	@Singular
	@JsonProperty(value = "SubErrors", required = true)
	Set<ApiValidationErrorTO> subErrors;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApiErrorTOBuilderImpl toBuilder() {
		return new ApiErrorTOBuilderImpl();
	}
	
	public static final class ApiErrorTOBuilderImpl extends ApiErrorTOBuilder<ApiErrorTO, ApiErrorTOBuilderImpl>
		implements BuildableType<ApiErrorTO, ApiErrorTOBuilderImpl> {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public final ApiErrorTOBuilderImpl initialize() {
			this.timestamp(LocalDateTime.now());
			
			return this;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public final ApiErrorTOBuilderImpl copy(@NonNull @Valid final ApiErrorTO model) {
			this.$fillValuesFrom(model);
			
			return this;
		}
		
		/**
		 * Create new object
		 * 
		 * @param status
		 * @param message
		 * @param exception
		 * @return ApiErrorTOBuilderImpl
		 */
		public final ApiErrorTOBuilderImpl createBy(@NotNull final HttpStatus status, @NotNull Throwable ex) {
			this.status(status);
			this.message(ex.getMessage());
			this.debugMessage(ex.getLocalizedMessage());
			
			return initialize();
		}
		
		/**
		 * Create new object
		 * 
		 * @param statusCode
		 * @param message
		 * @param exception
		 * @return ApiErrorTOBuilderImpl
		 */
		public final ApiErrorTOBuilderImpl createBy(@NotNull final HttpStatus status, @NotBlank final String message, @NotBlank final String debugMessage) {
			this.status(status);
			this.message(message);
			this.debugMessage(debugMessage);
			
			return initialize();
		}
	}
	
}
