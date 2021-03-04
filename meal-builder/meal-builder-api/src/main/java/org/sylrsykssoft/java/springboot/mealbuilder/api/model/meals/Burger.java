/**
 * Burger.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientsApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_TYPE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
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
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BurgerType;
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
 * Burger
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_BURGER_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { BURGER_TYPE_COLUMN, BURGER_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_BURGER_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class Burger extends BaseNameModel<Long> {
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Type field is mandatory")
	@Builder.Default
	BurgerType type = BurgerType.MEAT;
	
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
	@OneToMany(mappedBy = REPOSITORY_BURGER_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Bread> bugerBreads;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_INGREDIENT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<BurgerIngredient> burgerIngredients;
	
	@Embedded
	@NotNull(message = "BurgerCreationData field is mandatory")
	AuditModel burgerCreationData;
	
}
