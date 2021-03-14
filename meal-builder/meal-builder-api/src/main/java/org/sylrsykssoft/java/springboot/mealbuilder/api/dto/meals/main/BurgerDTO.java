/**
 * BurgerDTO.java 11 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.meals.main;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_BREAD_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_BREAD_MIN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_CATEGORY_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_CATEGORY_MIN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_INGREDIENT_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_INGREDIENT_MIN_LENGTH;

import java.io.Serializable;
import java.util.List;
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
 * BurgerDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "BurgerDTO", description = "Model BurgerDTO")
public class BurgerDTO extends BaseNameModelDTO<Long> implements Serializable {

	private static final long serialVersionUID = 2408070842095365290L;

	@NotNull(message = "Type field is mandatory")
	@JsonProperty(value = "Type", required = true)
	@Schema(name = "MealType", description = "MealType of Burger", required = true)
	MealTypeDataDTO type;

	@NotNull(message = "Preparation field is mandatory")
	@JsonProperty(value = "Preparation", required = true)
	@Schema(name = "Preparation", description = "Preparation of Burger", required = true)
	PreparationDataDTO preparation;

	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "Size", required = true)
	@Schema(name = "FoodSize", description = "Size FoodSize", required = true)
	FoodSizeDataDTO size;

	@NotNull(message = "Price field is mandatory")
	@JsonProperty(value = "Price", required = true)
	@Schema(name = "PriceDataDTO", description = "Price PriceDataDTO", required = true)
	PriceDataDTO price;

	@NotNull(message = "BurgerCategories field is mandatory")
	@Size(min = BURGER_CATEGORY_MIN_LENGTH, max = BURGER_CATEGORY_MAX_LENGTH)
	@JsonProperty(value = "Categories", required = true)
	@JsonManagedReference
	@Schema(name = "BurgerCategories", description = "Categories of Burger", required = true)
	@Singular
	@EqualsAndHashCode.Exclude
	transient Set<BurgerCategoryDTO> burgerCategories;

	@NotNull(message = "BugerBreads field is mandatory")
	@Size(min = BURGER_BREAD_MIN_LENGTH, max = BURGER_BREAD_MAX_LENGTH)
	@JsonProperty(value = "Breads", required = true)
	@JsonManagedReference
	@Schema(name = "BugerBreads", description = "Breads of Burger", required = true)
	@EqualsAndHashCode.Exclude
	transient List<BurgerBreadDTO> bugerBreads;

	@NotNull(message = "BurgerIngredients field is mandatory")
	@Size(min = BURGER_INGREDIENT_MIN_LENGTH, max = BURGER_INGREDIENT_MAX_LENGTH)
	@JsonProperty(value = "Ingredients", required = true)
	@JsonManagedReference
	@Schema(name = "BurgerIngredients", description = "Ingredients of Burger", required = true)
	@EqualsAndHashCode.Exclude
	transient Set<BurgerIngredientDTO> burgerIngredients;

	@NotNull(message = "BurgerCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "BurgerCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO burgerCreationData;

}
