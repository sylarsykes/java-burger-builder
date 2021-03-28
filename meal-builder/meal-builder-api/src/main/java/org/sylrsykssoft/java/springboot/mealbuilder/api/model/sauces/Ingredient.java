/**
 * Ingredient.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.sauces;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_TYPE_NAME_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_TYPE_NAME_COLUMN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.REPOSITORY_SAUCE_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCES_REPOSITORY_INGREDIENT_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCE_SCHEMA_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.IngredientType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Ingredient
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_INGREDIENT_TABLE_NAME, schema = SAUCE_SCHEMA_NAME, catalog = SAUCE_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { INGREDIENT_TYPE_NAME_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = SAUCES_REPOSITORY_INGREDIENT_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@EntityListeners(AuditingEntityListener.class)
public class Ingredient extends BaseNameModel<Long> {

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(20) default 'SAUCE'", length = INGREDIENT_TYPE_NAME_COLUMN_LENGTH)
	@NotNull(message = "Type field is mandatory")
	@Builder.Default
	IngredientType type = IngredientType.SAUCE;
	
	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_SAUCE_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<SauceIngredient> sauceIngredients;
	
	@Embedded
	@NotNull(message = "IngredientCreationData field is mandatory")
	AuditModel ingredientCreationData;
	
}
