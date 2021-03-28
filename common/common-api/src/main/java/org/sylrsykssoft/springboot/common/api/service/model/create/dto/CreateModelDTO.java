/**
 * CreateModelDTO.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.create.dto;

import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class CreateModelDTO<D extends BaseNameModelDTO<N>, N extends Number> {

}
