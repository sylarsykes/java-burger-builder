/**
 * BaseEmbeddedIdEntity.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto.embeddable;

import lombok.AccessLevel;
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
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseEmbeddedIdDTO<I extends BaseEmbeddableDTO> {

    I embeddedId;

}
