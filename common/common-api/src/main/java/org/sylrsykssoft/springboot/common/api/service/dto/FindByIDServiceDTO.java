/**
 * FindServiceDTO.java 04 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

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
@SuperBuilder(toBuilder = true, builderMethodName = "builderFindByIDService")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class FindByIDServiceDTO<N extends Number> extends FindByServiceDTO implements Serializable {
	
	private static final long serialVersionUID = 4105125720739724155L;
	
	@NotNull(message = "Id field is mandatory")
	N id;
	
}
