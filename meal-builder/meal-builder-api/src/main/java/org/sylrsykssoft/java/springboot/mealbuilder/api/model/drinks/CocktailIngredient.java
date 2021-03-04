/**
 * CocktailIngredient.java 28 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_COCKTAIL_INGREDIENT_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_COCKTAIL_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINK_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_ID_JOIN_COLUMN;

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
 * Cocktail ingredient
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_COCKTAIL_INGREDIENT_TABLE_NAME, schema = DRINK_SCHEMA_NAME, catalog = DRINK_SCHEMA_NAME)
@Entity(name = REPOSITORY_COCKTAIL_INGREDIENT_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class CocktailIngredient extends BaseModel<Integer> {
	
	@ManyToOne
	@JoinColumn(name = COCKTAIL_ID_JOIN_COLUMN, nullable = false)
	Cocktail cocktail;
	
	@ManyToOne
	@JoinColumn(name = INGREDIENT_ID_JOIN_COLUMN, nullable = false)
	Ingredient ingredient;
	
	@Embedded
	@NotNull(message = "IngredientData field is mandatory")
	IngredientData ingredientData;
	
}
