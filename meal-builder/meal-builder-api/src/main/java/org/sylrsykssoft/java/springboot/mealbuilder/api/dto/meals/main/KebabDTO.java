/**
 * SandwichDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.main;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_CATEGORY_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_CATEGORY_MIN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_INGREDIENT_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_INGREDIENT_MIN_LENGTH;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PreparationDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.embeddable.MealTypeDataDTO;
import org.sylrsykssoft.springboot.common.api.dto.BaseNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * KebabDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "KebabDTO", description = "Model KebabDTO")
public class KebabDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = 2408070842095365290L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "Type", required = true)
	@Schema(name = "MealType", description = "MealType of Kebab", required = true)
	MealTypeDataDTO type;
	
	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Kebab", required = true)
	PreparationDataDTO preparation;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "Size", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;
	
	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;
	
	@NotNull(message = "KebabCategories field is mandatory")
	@Size(min = KEBAB_CATEGORY_MIN_LENGTH, max = KEBAB_CATEGORY_MAX_LENGTH)
	@JsonProperty(value = "Categories", required = true)
	@JsonManagedReference
	@Schema(name = "KebabCategories", description = "Categories of Kebab", required = true)
	@Singular
	@EqualsAndHashCode.Exclude
	transient Set<KebabCategoryDTO> kebabCategories;
	
	@NotNull(message = "Bread field is mandatory")
	@JsonProperty(value = "Bread", required = true)
	@JsonManagedReference
	@Schema(name = "KebabBread", description = "Glass of Cocktail", required = true)
	KebabBreadDTO kebabBread;
	
	@NotNull(message = "KebabIngredients field is mandatory")
	@Size(min = KEBAB_INGREDIENT_MIN_LENGTH, max = KEBAB_INGREDIENT_MAX_LENGTH)
	@JsonProperty(value = "Ingredients", required = true)
	@JsonManagedReference
	@Schema(name = "KebabIngredients", description = "Ingredients of Kebab", required = true)
	@EqualsAndHashCode.Exclude
	transient Set<KebabIngredientDTO> kebabIngredients;
	
	@NotNull(message = "KebabCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "KebabCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO kebabCreationData;
	
}
