/**
 * ApiValidationErrorTO.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.error;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.springboot.common.api.builder.BuildableType;
import org.sylrsykssoft.springboot.common.api.builder.ToBuildableType;
import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;
import org.sylrsykssoft.springboot.common.api.dto.error.ApiValidationErrorTO.ApiValidationErrorTOBuilderImpl;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
public class ApiValidationErrorTO extends BaseDTO implements ToBuildableType<ApiValidationErrorTOBuilderImpl, ApiValidationErrorTO> {
	
	@NotBlank(message = "Object field is mandatory")
	String object;
	
	@Nullable
	String field;
	
	@Nullable
	Object rejectedValue;
	
	@NotBlank(message = "Message field is mandatory")
	String message;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApiValidationErrorTOBuilderImpl toBuilder() {
		return new ApiValidationErrorTOBuilderImpl();
	}
	
	public static final class ApiValidationErrorTOBuilderImpl extends ApiValidationErrorTOBuilder<ApiValidationErrorTO, ApiValidationErrorTOBuilderImpl>
		implements BuildableType<ApiValidationErrorTO, ApiValidationErrorTOBuilderImpl> {
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public final ApiValidationErrorTOBuilderImpl initialize() {
			return this;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public final ApiValidationErrorTOBuilderImpl copy(@NonNull @Valid final ApiValidationErrorTO model) {
			this.$fillValuesFrom(model);
			
			return this;
		}
		
		public final ApiValidationErrorTOBuilderImpl createBy(@NotBlank final String object, @NotBlank final String message) {
			this.object(object);
			this.message(message);
			
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
		public final ApiValidationErrorTOBuilderImpl createBy(@NotBlank final String object, @NotBlank final String field, @NotNull final Object rejectedValue, @NotBlank final String message) {
			this.object(object);
			this.field(field);
			this.rejectedValue(rejectedValue);
			this.message(message);
			
			return initialize();
		}
	}
}
