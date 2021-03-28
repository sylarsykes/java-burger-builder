/**
 * Kebab.java 8 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.main;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOOD_SIZE_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_BREAD_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_CATEGORY_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_CATEGORY_MIN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_INGREDIENT_MAX_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_INGREDIENT_MIN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.REPOSITORY_KEBAB_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.REPOSITORY_KEBAB_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_TYPE_TYPE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.REPOSITORY_CATEGORY_TABLE_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PreparationData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.embeddable.MealTypeData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Kebab
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_KEBAB_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { MEAL_TYPE_TYPE_COLUMN, FOOD_SIZE_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_KEBAB_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@EntityListeners(AuditingEntityListener.class)
public class Kebab extends BaseNameModel<Long> {

	@Embedded
	@NotNull(message = "Type field is mandatory")
	MealTypeData type;
	
	@Embedded
	@NotNull(message = "Preparation field is mandatory")
	PreparationData preparation;
	
	@Embedded
	@NotNull(message = "Size field is mandatory")
	FoodSizeData size;
	
	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_CATEGORY_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Size(min = KEBAB_CATEGORY_MIN_LENGTH, max = KEBAB_CATEGORY_MAX_LENGTH)
	Set<KebabCategory> kebabCategories;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = KEBAB_BREAD_ID_JOIN_COLUMN, referencedColumnName = BASE_MODEL_NAME_ID_COLUMN)
	KebabBread kebabBread;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_INGREDIENT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Size(min = KEBAB_INGREDIENT_MIN_LENGTH, max = KEBAB_INGREDIENT_MAX_LENGTH)
	Set<KebabIngredient> kebabIngredients;
	
	@Embedded
	@NotNull(message = "KebabCreationData field is mandatory")
	AuditModel kebabCreationData;
	
}
