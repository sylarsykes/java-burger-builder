/**
 * GlassCocktailDTO.java 9 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.GlassCocktailSize;
import org.sylrsykssoft.springboot.common.api.dto.BaseModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * GlassCocktailDTO
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Schema(name = "GlassCocktailDTO", description = "Model GlassCocktailDTO")
public class GlassCocktailDTO extends BaseModelDTO<Integer> implements Serializable {

	private static final long serialVersionUID = 2064585136333707152L;
	
	@NotNull(message = "Name field is mandatory")
	@JsonProperty(value = "Name", required = true)
	@Schema(name = "Name", description = "Name of the glass for Cocktail", required = true)
	NameModelDTO name;
	
	@NotNull(message = "Size field is mandatory")
	@JsonProperty(value = "Size", required = true)
	@Schema(name = "Size", description = "Size of the glass for Cocktail", required = true)
	@Builder.Default
	GlassCocktailSize size = GlassCocktailSize.MEDIUM;
	
	@JsonIgnore
	CocktailDTO cocktail;

	@NotNull(message = "GlassCocktailCreationData field is mandatory")
	@Schema(name = "AuditModelDTO", description = "GlassCocktailCreationData AuditModelDTO", required = true)
	@JsonIgnore
	AuditModelDTO cocktailCreationData;
	
}
