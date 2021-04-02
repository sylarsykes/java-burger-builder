/**
 * LocalizedModel.java 15 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_LOCALIZED_MODEL_LOCALE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_LOCALIZED_LOCALE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_ID_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nLocalizedModelMessages.LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
 * LocalizedModel
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
@Embeddable
public class LocalizedModel extends BaseEmbeddable implements Serializable {

	private static final long serialVersionUID = -811000266636508172L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = BASE_MODEL_NAME_ID_COLUMN, updatable = false, nullable = false)
	@NotNull(message = LOCALIZED_MODEL_ID_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE)
	Long id;

	@Column(name = BASE_LOCALIZED_MODEL_LOCALE_COLUMN, nullable = false, length = MAX_LENGTH_LOCALIZED_LOCALE)
	@NotBlank(message = LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_LOCALIZED_LOCALE, max = MAX_LENGTH_LOCALIZED_LOCALE, message = LOCALIZED_MODEL_LOCALE_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	String locale;

}
