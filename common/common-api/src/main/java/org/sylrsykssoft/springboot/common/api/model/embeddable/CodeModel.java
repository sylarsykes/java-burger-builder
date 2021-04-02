/**
 * CodeModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_CODE_MODEL_NAME_CODE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MAX_LENGTH_CODE;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.MIN_LENGTH_CODE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nCodeModelMessages.CODE_MODEL_CODE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE;
import static org.sylrsykssoft.springboot.common.api.i18n.messages.embeddable.CommonI18nCodeModelMessages.CODE_MODEL_CODE_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE;

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
 * Embeddable code model
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
public class CodeModel extends BaseEmbeddable {

	@Column(name = BASE_CODE_MODEL_NAME_CODE_COLUMN, nullable = false, unique = true, length = MAX_LENGTH_CODE)
	@NotBlank(message = CODE_MODEL_CODE_FIELD_VALIDATION_CONSTRAINT_NOTBLANK_MESSAGE)
	@Size(min = MIN_LENGTH_CODE, max = MAX_LENGTH_CODE, message = CODE_MODEL_CODE_FIELD_VALIDATION_CONSTRAINT_SIZE_MESSAGE)
	String code;
	
}
