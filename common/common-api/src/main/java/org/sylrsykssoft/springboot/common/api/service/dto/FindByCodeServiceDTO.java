/**
 * FindByNameFindServiceDTO.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.dto;

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
public class FindByCodeServiceDTO extends FindByServiceDTO implements Serializable {

	private static final long serialVersionUID = -7520057302629635718L;
	
	@NotNull(message = "Code field is mandatory")
	String code;
	
}
