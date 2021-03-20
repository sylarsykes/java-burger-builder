/**
 * LocalizedDrinkDTO.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import org.sylrsykssoft.springboot.common.api.dto.embeddable.BaseEmbeddedNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "LocalizedDrinkDTO", description = "Model LocalizedDrinkDTO")
public class LocalizedDrinkDTO extends BaseEmbeddedNameModelDTO<LocalizedModelDTO> {

	@JsonBackReference
	DrinkDTO drink;
		
}
