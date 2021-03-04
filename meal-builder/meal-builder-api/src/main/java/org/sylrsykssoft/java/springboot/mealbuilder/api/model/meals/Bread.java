/**
 * Bread.java 1 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BREAD_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BREAD_TYPE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BURGER_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BREAD_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BREAD_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.SandwichApiConstants.SANDWICH_ID_JOIN_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_NAME;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FoodSize;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.BreadTypeMeal;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_BREAD_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { BREAD_TYPE_COLUMN, BREAD_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_BREAD_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class Bread extends BaseNameModel<Integer> {
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Type field is mandatory")
	BreadTypeMeal type;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Size field is mandatory")
	@Builder.Default
	FoodSize size = FoodSize.MEDIUM;
	
	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;
	
	@ManyToOne
    @JoinColumn(name = BURGER_ID_JOIN_COLUMN, referencedColumnName = BASE_MODEL_NAME_ID_COLUMN, nullable = false)
	Burger burger;
	
	@ManyToOne
	@JoinColumn(name = SANDWICH_ID_JOIN_COLUMN, referencedColumnName = BASE_MODEL_NAME_ID_COLUMN, nullable = false)
	Sandwich sandwich;
	
	@Embedded
	@NotNull(message = "BreadCreationData field is mandatory")
	AuditModel breadCreationData;
	
}
