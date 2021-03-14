/**
 * BurgerCategory.java 8 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.main;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_CATEGORY_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_CATEGORY_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.CATEGORY_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.Category;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * BurgerCategory
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_BURGER_CATEGORY_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME)
@Entity(name = REPOSITORY_BURGER_CATEGORY_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
public class BurgerCategory extends BaseModel<Integer> {

	@ManyToOne
	@JoinColumn(name = BURGER_ID_JOIN_COLUMN, nullable = false)
	Burger burger;
	
	@ManyToOne
	@JoinColumn(name = CATEGORY_ID_JOIN_COLUMN, nullable = false)
	Category category;
	
	@Column(name = "created_at", nullable = false)
	@NotNull(message = "CreatedAt field is mandatory")
	LocalDateTime createdAt;
	
}