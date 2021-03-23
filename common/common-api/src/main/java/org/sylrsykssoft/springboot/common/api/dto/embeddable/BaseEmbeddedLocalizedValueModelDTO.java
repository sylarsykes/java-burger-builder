/**
 * BaseEmbeddedLocalizedValueModelDTO.java 15 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * BaseEmbeddedLocalizedValueModelDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseEmbeddedLocalizedValueModelDTO<I extends BaseEmbeddableDTO> extends BaseEmbeddedIdDTO<I> {

	@NotNull(message = "Value field is mandatory")
	LocalizedValueModelDTO value;
	
}
