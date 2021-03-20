/**
 * Bread.java 1 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.main;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOOD_SIZE_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.REPOSITORY_KEBAB_BREAD_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.REPOSITORY_KEBAB_BREAD_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.KebabApiConstants.KEBAB_BREAD_MAPPED_BY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.embeddable.BreadData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * KebabBread
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_KEBAB_BREAD_TABLE_NAME, schema = MEAL_SCHEMA_NAME, catalog = MEAL_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { FOOD_SIZE_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_KEBAB_BREAD_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class KebabBread extends BaseNameModel<Integer> {
	
	@Embedded
	BreadData bread;
	
	@OneToOne(mappedBy = KEBAB_BREAD_MAPPED_BY_NAME)
	Kebab kebab;
	
}
