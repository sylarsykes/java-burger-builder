/**
 * Sauce.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.sauces;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOOD_SIZE_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.REPOSITORY_SAUCE_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.REPOSITORY_SAUCE_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCE_SCHEMA_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PreparationData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Sauce
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_SAUCE_TABLE_NAME, schema = SAUCE_SCHEMA_NAME, catalog = SAUCE_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { FOOD_SIZE_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_SAUCE_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class Sauce extends BaseNameModel<Long> {

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
	@OneToMany(mappedBy = REPOSITORY_INGREDIENT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SauceIngredient> sauceIngredients;

	@Embedded
	@NotNull(message = "SauceCreationData field is mandatory")
	AuditModel sauceCreationData;

}
