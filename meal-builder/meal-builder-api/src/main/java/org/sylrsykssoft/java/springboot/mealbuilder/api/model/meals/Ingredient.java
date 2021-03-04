/**
 * Ingredient.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_TYPE_NAME_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.DessertApiConstants.REPOSITORY_DESSERT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.REPOSITORY_FOOD_STARTER_TABLE_KEY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_REPOSITORY_INGREDIENT_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SaladApiConstants.REPOSITORY_SALAD_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.REPOSITORY_SANDWICH_TABLE_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.IngredientType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Ingredient
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_INGREDIENT_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { INGREDIENT_TYPE_NAME_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = MEALS_REPOSITORY_INGREDIENT_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class Ingredient extends BaseNameModel<Long> {

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Type field is mandatory")
	@Builder.Default
	IngredientType type = IngredientType.BURGER;
	
	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_FOOD_STARTER_TABLE_KEY_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<FoodStarterIngredient> foodStarterIngredients;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_SALAD_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SaladIngredient> saladIngredients;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_SANDWICH_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SandwichIngredient> sandwichIngredients;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_BURGER_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<BurgerIngredient> burgerIngredients;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_DESSERT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<DessertIngredient> dessertIngredients;
	
	@Embedded
	@NotNull(message = "IngredientCreationData field is mandatory")
	AuditModel ingredientCreationData;
	
}
