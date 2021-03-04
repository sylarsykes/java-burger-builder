/**
 * Salad.java 28 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.REPOSITORY_SANDWICH_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.REPOSITORY_SANDWICH_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.SANDWICH_SIZE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.List;
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
 * Sandwich
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_SANDWICH_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { SANDWICH_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_SANDWICH_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class Sandwich extends BaseNameModel<Long> {

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
	@OneToMany(mappedBy = REPOSITORY_SANDWICH_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Bread> sandwichBreads;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_INGREDIENT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SandwichIngredient> sandwichIngredients;
	
	@Embedded
	@NotNull(message = "SandwichCreationData field is mandatory")
	AuditModel sandwichCreationData;
}
