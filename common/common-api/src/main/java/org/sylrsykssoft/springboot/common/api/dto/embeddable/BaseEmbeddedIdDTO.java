/**
 * BaseEmbeddedIdEntity.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonBaseModelProperties.BASE_MODEL_EMBEDDED_ID_JSON_PROPERTY;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Base model for embedable id objects
 *
 * @author juan.gonzalez.fernandez.jgf
 * @param <I> Class model for name embeddable objects
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(includeFieldNames = true, callSuper = true)
public class BaseEmbeddedIdDTO<I extends BaseEmbeddableDTO> {

	@JsonProperty(value = BASE_MODEL_EMBEDDED_ID_JSON_PROPERTY, required = true)
	I embeddedId;

}
