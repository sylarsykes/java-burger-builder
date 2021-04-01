/**
 * StartEndDateModel.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model.embeddable;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_START_END_DATE_MODEL_NAME_END_DATE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_START_END_DATE_MODEL_NAME_START_DATE_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_START_END_DATE_MODEL_NAME_START_DATE_COLUMN_DEFAULT_VALUE;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * StartEndDateModel
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
public class StartEndDateModel extends BaseEmbeddable {

	@Column(name = BASE_START_END_DATE_MODEL_NAME_START_DATE_COLUMN, columnDefinition = BASE_START_END_DATE_MODEL_NAME_START_DATE_COLUMN_DEFAULT_VALUE, nullable = false)
	@NotNull(message = "StartDate field is mandatory")
	LocalDateTime startDate;
	
	@Column(name = BASE_START_END_DATE_MODEL_NAME_END_DATE_COLUMN, nullable = true)
	@Nullable
	LocalDateTime endDate;
	
}
