/**
 * Drink.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FOOD_SIZE_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINK_TYPE_TYPE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINK_TYPE_TYPE_COLUMN_DEFAULT_VALUE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DRINK_TYPE_TYPE_COLUMN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.REPOSITORY_DRINK_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.REPOSITORY_DRINK_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINK_SCHEMA_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_LOCALE_JPA;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DrinkType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.BaseNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Drink
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_DRINK_TABLE_NAME, schema = DRINK_SCHEMA_NAME, catalog = DRINK_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { DRINK_TYPE_TYPE_COLUMN, FOOD_SIZE_SIZE_COLUMN,
				BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_DRINK_ENTITY_NAME)
@Value
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@EntityListeners(AuditingEntityListener.class)
public class Drink extends BaseNameModel<Long> {
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = DRINK_TYPE_TYPE_COLUMN_DEFAULT_VALUE, length = DRINK_TYPE_TYPE_COLUMN_LENGTH)
	@NotNull(message = "Type field is mandatory")
	@Builder.Default
	DrinkType type = DrinkType.NO_ALCOHOLIC;

	@Embedded
	@NotNull(message = "Size field is mandatory")
	FoodSizeData size;

	@Embedded
	@NotNull(message = "Price field is mandatory")
	PriceData price;
	
	@OneToMany(mappedBy = REPOSITORY_DRINK_TABLE_NAME, cascade = { CascadeType.ALL }, orphanRemoval = true)
	@MapKey(name = BASE_LOCALIZED_MODEL_LOCALE_JPA)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Builder.Default
	Map<String, LocalizedNameDrink> localizationsName = new HashMap<>();
	
	@OneToMany(mappedBy = REPOSITORY_DRINK_TABLE_NAME, cascade = { CascadeType.ALL }, orphanRemoval = true)
	@MapKey(name = BASE_LOCALIZED_MODEL_LOCALE_JPA)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Builder.Default
	Map<String, LocalizedDescriptionDrink> localizationsDescription = new HashMap<>();

	@Embedded
	AuditModel drinkCreationData;

}
