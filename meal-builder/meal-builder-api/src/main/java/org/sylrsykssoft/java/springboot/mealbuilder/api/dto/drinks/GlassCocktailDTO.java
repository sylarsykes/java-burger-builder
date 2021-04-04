/**
 * GlassCocktailDTO.java 9 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.FoodSizeI18nMessages.FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.json.properties.embeddable.FoodSizeJsonProperties.FOOD_SIZE_MODEL_SIZE_JSON_OBJECT_PROPERTY;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nNameModelMessages.NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.json.properties.embeddable.CommonJsonNameModelProperties.NAME_MODEL_NAME_JSON_OBJECT_PROPERTY;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GlassCocktailSize;
import org.sylrsykssoft.springboot.common.api.dto.BaseModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * GlassCocktailDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "GlassCocktailDTO", description = "Model GlassCocktailDTO")
public class GlassCocktailDTO extends BaseModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = 2064585136333707152L;
	
	@NotNull(message = NAME_MODEL_NAME_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = NAME_MODEL_NAME_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = NAME_MODEL_NAME_JSON_OBJECT_PROPERTY, description = "Name of the glass for Cocktail", required = true)
	NameModelDTO name;
	
	@NotNull(message = FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@JsonProperty(value = FOOD_SIZE_MODEL_SIZE_JSON_OBJECT_PROPERTY, required = true)
	@Schema(name = FOOD_SIZE_MODEL_SIZE_JSON_OBJECT_PROPERTY, description = "Size of the glass for Cocktail", required = true)
	@Builder.Default
	GlassCocktailSize size = GlassCocktailSize.MEDIUM;
	
	@JsonBackReference
	@Hidden
	CocktailDTO cocktail;

	@NotNull(message = "GlassCocktailCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "GlassCocktailCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO cocktailCreationData;
	
}
