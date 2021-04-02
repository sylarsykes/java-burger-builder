/**
 * BaseAuditModelDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;

import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonBaseModelProperties.BASE_MODEL_ID_JSON_PROPERTY;

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
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
public class BaseModelDTO<N extends Number> {

	@JsonProperty(value = BASE_MODEL_ID_JSON_PROPERTY, required = true)
	N id;

}
