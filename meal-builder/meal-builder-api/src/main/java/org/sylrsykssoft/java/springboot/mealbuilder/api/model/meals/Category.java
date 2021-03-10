/**
 * Category.java 8 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.REPOSITORY_KEBAB_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.REPOSITORY_CATEGORY_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.REPOSITORY_CATEGORY_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.REPOSITORY_SANDWICH_TABLE_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_CODE_MODEL_NAME_CODE_COLUMN;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.main.BurgerCategory;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.main.KebabCategory;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.main.SandwichCategory;
import org.sylrsykssoft.springboot.common.api.model.BaseCodeModel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Meal Category
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_CATEGORY_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { BASE_CODE_MODEL_NAME_CODE_COLUMN }) })
@Entity(name = REPOSITORY_CATEGORY_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class Category extends BaseCodeModel<Integer> {

	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_SANDWICH_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SandwichCategory> sandwichCategories;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_BURGER_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<BurgerCategory> burgerCategories;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_KEBAB_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<KebabCategory> kebabCategories;
	
}
