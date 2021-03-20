/**
 * DescriptionModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_NAME_DESCRIPTION_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.DESCRIPTION_FIELD_COLUMN_DEFINITION;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_DESCRIPTION;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Embeddable description model
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Embeddable
public class DescriptionModel extends BaseEmbeddable {

	@Column(name = BASE_NAME_MODEL_NAME_DESCRIPTION_COLUMN, nullable = true, columnDefinition = DESCRIPTION_FIELD_COLUMN_DEFINITION, length = MAX_LENGTH_DESCRIPTION)
	@Size(max = MAX_LENGTH_DESCRIPTION)
	String description;
	
}
