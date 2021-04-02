/**
 * BaseAuditModelDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;

import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class BaseAuditModelDTO<N extends Number> extends BaseModelDTO<N> {

	@JsonIgnore
	AuditModelDTO auditData;

}
