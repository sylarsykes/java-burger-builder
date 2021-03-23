/**
 * BaseEmbeddedLocalizedValueModel.java 15 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * BaseEmbeddedLocalizedValueModel
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseEmbeddedLocalizedValueModel<I extends BaseEmbeddable> extends BaseEmbeddedId<I> {

	@Embedded
	@NotNull(message = "Value field is mandatory")
	LocalizedValueModel value;
	
}
