/**
 * BaseCodeModel.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Base model for code entities
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, includeFieldNames = true)
public class BaseCodeModel<N extends Number> extends BaseModel<N> {

	@Embedded
	@NotNull(message = "Code field is mandatory")
	CodeModel code;
	
	@Embedded
	@Nullable
	DescriptionModel description;
	
	@Embedded
	@NotNull(message = "AuditData field is mandatory")
	AuditModel auditData;
	
}
