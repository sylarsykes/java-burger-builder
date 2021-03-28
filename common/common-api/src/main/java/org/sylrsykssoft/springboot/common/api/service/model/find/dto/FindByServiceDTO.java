/**
 * FindServiceDTO.java 04 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.service.model.find.dto;

import lombok.AccessLevel;
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
@SuperBuilder(toBuilder = true, builderMethodName = "builderFindByService")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FindByServiceDTO {

}
