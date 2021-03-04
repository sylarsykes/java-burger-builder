/**
 * BaseAuditModelDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class BaseModelDTO<N extends Number> {

	@JsonProperty(value = "Id", required = true)
	N id;
	
}
