/**
 * DrinkFindByIDService.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.find.dto;

import org.sylrsykssoft.springboot.common.api.service.model.find.dto.FindByIDServiceDTO;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class DrinkFindByIDService extends FindByIDServiceDTO<Long> {
	
	 private static final long serialVersionUID = -134310178660674396L;

}
