/**
 * BaseEmbeddedIdEntity.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

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
@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseEmbeddedId<I extends BaseEmbeddable> {

    @EmbeddedId
    I embeddedId;

}
