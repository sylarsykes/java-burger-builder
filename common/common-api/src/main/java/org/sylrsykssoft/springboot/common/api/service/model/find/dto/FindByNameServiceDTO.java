/**
 * FindByNameFindServiceDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.find.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Find by name service DTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class FindByNameServiceDTO extends FindByServiceDTO implements Serializable {

	private static final long serialVersionUID = 7136350971929344787L;
	
	@NotNull(message = "Name field is mandatory")
	String name;
	
}
