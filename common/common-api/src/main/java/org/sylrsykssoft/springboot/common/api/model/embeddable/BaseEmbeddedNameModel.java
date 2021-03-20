/**
 * BaseEmbeddedNameModel.java 15 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
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
public class BaseEmbeddedNameModel<I extends BaseEmbeddable> extends BaseEmbeddedId<I> {

	@Embedded
	@NotNull(message = "Name field is mandatory")
	NameModel name;
	
	@Embedded
	@Nullable
	DescriptionModel description;
	
}
