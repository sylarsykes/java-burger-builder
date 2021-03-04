/**
 * FoodStarterIngredient.java 28 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.INGREDIENT_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.FOOD_STARTER_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.REPOSITORY_FOOD_STARTER_INGREDIENT_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.REPOSITORY_FOOD_STARTER_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.IngredientData;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Food starter ingredient
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_FOOD_STARTER_INGREDIENT_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME)
@Entity(name = REPOSITORY_FOOD_STARTER_INGREDIENT_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class FoodStarterIngredient extends BaseModel<Integer> {
	
	@ManyToOne
	@JoinColumn(name = FOOD_STARTER_ID_JOIN_COLUMN, nullable = false)
	FoodStarter foodStarter;
	
	@ManyToOne
	@JoinColumn(name = INGREDIENT_ID_JOIN_COLUMN, nullable = false)
	Ingredient ingredient;
	
	@Embedded
	@NotNull(message = "IngredientData field is mandatory")
	IngredientData ingredientData;
	
}