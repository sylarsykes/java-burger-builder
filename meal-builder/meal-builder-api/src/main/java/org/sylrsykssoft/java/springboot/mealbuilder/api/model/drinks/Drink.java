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
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_FIELD_NAME_JPA;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_LOCALE_JPA;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nStartEndDateModelMessages.START_END_DATE_MODEL_STARTENDDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks.DrinkI18nMessages.DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.FoodSizeI18nMessages.FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.embeddable.PriceDataI18nMessages.PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyJoinColumn;
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
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@EntityListeners(AuditingEntityListener.class)
public class Drink extends BaseNameModel<Long> {

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = DRINK_TYPE_TYPE_COLUMN_DEFAULT_VALUE, length = DRINK_TYPE_TYPE_COLUMN_LENGTH)
	@NotNull(message = DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	@Builder.Default
	DrinkType type = DrinkType.NO_ALCOHOLIC;

	@Embedded
	@NotNull(message = FOOD_SIZE_MODEL_SIZE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	FoodSizeData size;

	@Embedded
	@NotNull(message = PRICE_DATA_MODEL_PRICE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	PriceData price;

	@Embedded
	@NotNull(message = START_END_DATE_MODEL_STARTENDDATE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	StartEndDateModel drinkStartEndDateData;

	@OneToMany(mappedBy = REPOSITORY_DRINK_TABLE_NAME, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@MapKeyJoinColumn(name = BASE_LOCALIZED_MODEL_LOCALE_JPA)
	@MapKeyJoinColumn(name = BASE_LOCALIZED_MODEL_FIELD_NAME_JPA)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	Map<LocalizedFieldNameModel, LocalizedDrink> localizationsData = new HashMap<>();

	@Embedded
	AuditModel drinkCreationData;

}
