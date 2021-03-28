/**
 * GlassCocktail.java 3 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.COCKTAIL_GLASS_COCKTAIL_JOIN_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GLASS_COCKTAIL_NAME_SIZE_COLUMN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GLASS_COCKTAIL_NAME_SIZE_COLUMN_DEFAULT_VALUE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GLASS_COCKTAIL_NAME_SIZE_COLUMN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_GLASS_COCKTAIL_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_GLASS_COCKTAIL_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINK_SCHEMA_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_NAME_COLUMN;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GlassCocktailSize;
import org.sylrsykssoft.springboot.common.api.model.BaseModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Glass cocktail
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = REPOSITORY_GLASS_COCKTAIL_TABLE_NAME, schema = DRINK_SCHEMA_NAME, catalog = DRINK_SCHEMA_NAME, uniqueConstraints = {
		@UniqueConstraint(columnNames = { GLASS_COCKTAIL_NAME_SIZE_COLUMN, BASE_NAME_MODEL_NAME_NAME_COLUMN }) })
@Entity(name = REPOSITORY_GLASS_COCKTAIL_ENTITY_NAME)
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@EntityListeners(AuditingEntityListener.class)
public class GlassCocktail extends BaseModel<Integer> {

	@Embedded
	@NotNull(message = "Name field is mandatory")
	NameModel name;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = GLASS_COCKTAIL_NAME_SIZE_COLUMN_DEFAULT_VALUE, length = GLASS_COCKTAIL_NAME_SIZE_COLUMN_LENGTH)
	@NotNull(message = "Size field is mandatory")
	GlassCocktailSize size = GlassCocktailSize.MEDIUM;
	
	@OneToOne(mappedBy = COCKTAIL_GLASS_COCKTAIL_JOIN_COLUMN)
	Cocktail cocktail;
	
	@Embedded
	@NotNull(message = "GlassCocktailCreationData field is mandatory")
	AuditModel glassCocktailCreationData;
	
}
