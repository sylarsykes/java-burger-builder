/**
 * CommonJsonAuditModelProperties.java 2 abr. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.json.properties.embeddable;

import lombok.experimental.UtilityClass;

/**
 * CommonJsonAuditModelProperties
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class CommonJsonAuditModelProperties {

	public static final String AUDIT_MODEL_AUDIT_JSON_OBJECT_PROPERTY = "AuditData";
	public static final String AUDIT_MODEL_CREATE_BY_JSON_PROPERTY = "createdBy";
	public static final String AUDIT_MODEL_CREATE_DATE_JSON_PROPERTY = "createdDate";
	public static final String AUDIT_MODEL_LAST_MODIFIED_BY_JSON_PROPERTY = "lastModifiedBy";
	public static final String AUDIT_MODEL_LAST_MODIFIED_DATE_JSON_PROPERTY = "lastModifiedDate";
	
}
