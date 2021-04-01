/**
 * Cocktail.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_CLASSIFICATION_TYPE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_CLASSIFICATION_TYPE_COLUMN_DEFAULT_VALUE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_CLASSIFICATION_TYPE_COLUMN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GLASS_COCKTAIL_ID_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_COCKTAIL_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_COCKTAIL_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINK_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_LOCALE_JPA;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.CocktailClassification;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PreparationData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Cocktail
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_COCKTAIL_TABLE_NAME, schema = DRINK_SCHEMA_NAME, catalog = DRINK_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { COCKTAIL_CLASSIFICATION_TYPE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_COCKTAIL_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@EntityListeners(AuditingEntityListener.class)
public class Cocktail extends BaseNameModel<Long> {

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = COCKTAIL_CLASSIFICATION_TYPE_COLUMN_DEFAULT_VALUE, length = COCKTAIL_CLASSIFICATION_TYPE_COLUMN_LENGTH)
	@NotNull(message = "Type field is mandatory")
	CocktailClassification type = CocktailClassification.APPETIZER;

	@Embedded
	@NotNull(message = "Preparation field is mandatory")
	PreparationData preparation;

	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;

	@Embedded
	@NotNull(message = "CocktailStartEndDateData field is mandatory")
	StartEndDateModel cocktailStartEndDateData;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = GLASS_COCKTAIL_ID_JOIN_COLUMN, referencedColumnName = BASE_MODEL_NAME_ID_COLUMN)
	GlassCocktail glassCocktail;

	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = REPOSITORY_INGREDIENT_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<CocktailIngredient> cocktailIngredients;

	@OneToMany(mappedBy = REPOSITORY_COCKTAIL_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@MapKey(name = BASE_LOCALIZED_MODEL_LOCALE_JPA)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Builder.Default
	Map<String, LocalizedNameCocktail> localizationsName = new HashMap<>();

	@OneToMany(mappedBy = REPOSITORY_COCKTAIL_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@MapKey(name = BASE_LOCALIZED_MODEL_LOCALE_JPA)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Builder.Default
	Map<String, LocalizedDescriptionCocktail> localizationsDescription = new HashMap<>();

	@OneToMany(mappedBy = REPOSITORY_COCKTAIL_TABLE_NAME, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@MapKey(name = BASE_LOCALIZED_MODEL_LOCALE_JPA)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Builder.Default
	Map<String, LocalizedPreparationCocktail> localizationsPreparation = new HashMap<>();

	@Embedded
	@NotNull(message = "CocktailCreationData field is mandatory")
	AuditModel cocktailCreationData;

}
