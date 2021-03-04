/**
 * BaseAuditModelDTO.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.dto;

import lombok.AccessLevel;
import lombok.Data;
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
@SuperBuilder(toBuilder = true)
public class BaseDTO {

}
