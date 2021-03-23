/**
 * LocalizedFieldNameModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_LOCALE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_NAME_FIELD_NAME_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_FIELD_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_FIELD_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_LOCALE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
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
 * Embeddable name model
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
public class LocalizedFieldNameModel extends BaseEmbeddable implements Serializable {

	private static final long serialVersionUID = -3567111343891297525L;

	@Column(name = BASE_MODEL_NAME_ID_COLUMN, updatable = false, nullable = false)
	Long id;
	
	@Column(name = BASE_LOCALIZED_MODEL_LOCALE_COLUMN, nullable = false, length = MAX_LENGTH_LOCALIZED_LOCALE)
	@Size(min = MIN_LENGTH_LOCALIZED_LOCALE, max = MAX_LENGTH_LOCALIZED_LOCALE)
	String locale;
	
	@Column(name = BASE_LOCALIZED_MODEL_NAME_FIELD_NAME_COLUMN, nullable = false, length = MAX_LENGTH_LOCALIZED_FIELD_NAME)
	@NotBlank(message = "Field name field is mandatory")
	@Size(min = MIN_LENGTH_LOCALIZED_FIELD_NAME, max = MAX_LENGTH_LOCALIZED_FIELD_NAME)
	String fieldName;
	
}
