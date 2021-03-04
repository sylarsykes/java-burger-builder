/**
 * ToBuildableType.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.builder;

import org.sylrsykssoft.springboot.common.api.dto.BaseDTO;

/**
 * ToBuildableType
 *
 * @author juan.gonzalez.fernandez.jgf
 * @param <B> Builder class type
 * @param <M> Model class type
 * @param <N> Number class type
 */
@FunctionalInterface
public interface ToBuildableType<B extends BuildableType<M, B>, M extends BaseDTO> {

    /**
     * Get a new instance of Builder class
     * @return B Clase Builder
     */
    B toBuilder();

}
