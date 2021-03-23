/**
 * LocalizedValueModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_NAME_VALUE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.DESCRIPTION_FIELD_COLUMN_DEFINITION;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_VALUE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_VALUE;

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
public class LocalizedValueModel extends BaseEmbeddable {

	@Column(name = BASE_LOCALIZED_MODEL_NAME_VALUE_COLUMN, nullable = false, columnDefinition = DESCRIPTION_FIELD_COLUMN_DEFINITION, length = MAX_LENGTH_LOCALIZED_VALUE)
	@Size(min = MIN_LENGTH_LOCALIZED_VALUE, max = MAX_LENGTH_LOCALIZED_VALUE)
	String value;
	
}
