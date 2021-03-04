/**
 * BaseCodeModelDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Base class for DTOs
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @param <N> Class type than extends of Number
 */
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC, onConstructor = @__(@JsonCreator))
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class BaseCodeModelDTO<N extends Number> extends BaseModelDTO<N> {

	@NonNull
	CodeModelDTO code;
	
	@Nullable
	DescriptionModelDTO description;
	
	@NonNull
	AuditModelDTO auditData;
	
}
