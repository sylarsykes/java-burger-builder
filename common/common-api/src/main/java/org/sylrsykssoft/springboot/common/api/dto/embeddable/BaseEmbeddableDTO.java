/**
 * BaseEmbeddable.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Base model for name embeddable objects
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class BaseEmbeddableDTO {

}
