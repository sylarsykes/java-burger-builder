/**
 * FoodStarter.java 28 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.FOOD_STARTER_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.REPOSITORY_FOOD_STARTER_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.FoodStarterApiConstants.REPOSITORY_FOOD_STARTER_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
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

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FoodSize;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PreparationData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Food starter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_FOOD_STARTER_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { FOOD_STARTER_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_FOOD_STARTER_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class FoodStarter extends BaseNameModel<Long> {

	@Embedded
	@NotNull(message = "Preparation field is mandatory")
	PreparationData preparation;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Size field is mandatory")
	@Builder.Default
	FoodSize size = FoodSize.MEDIUM;
	
	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_INGREDIENT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<FoodStarterIngredient> foodStarterIngredients;
	
	@Embedded
	@NotNull(message = "FoodStarterCreationData field is mandatory")
	AuditModel foodStarterCreationData;
}
