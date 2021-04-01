/**
 * CommonAPIConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.configuration;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class CommonAPIConstants {

	public static final int MAX_LENGTH_CODE = 10;
	public static final int MIN_LENGTH_CODE = 2;
	public static final int MAX_LENGTH_NAME = 256;
	public static final int MIN_LENGTH_NAME = 2;
	public static final int MAX_LENGTH_DESCRIPTION = 10000;
	public static final int MIN_LENGTH_DESCRIPTION = 0;
	public static final String DESCRIPTION_FIELD_COLUMN_DEFINITION = "TEXT";
	public static final int MAX_LENGTH_NICKNAME_USER = 60;
	public static final int MIN_LENGTH_NICKNAME_USER = 2;
	public static final int MAX_LENGTH_LOCALIZED_LOCALE = 2;
	public static final int MIN_LENGTH_LOCALIZED_LOCALE = 2;
	public static final int MAX_LENGTH_LOCALIZED_FIELD_NAME = 60;
	public static final int MIN_LENGTH_LOCALIZED_FIELD_NAME = 1;
	public static final int MAX_LENGTH_LOCALIZED_VALUE = 10000;
	public static final int MIN_LENGTH_LOCALIZED_VALUE = 1;
	public static final int LENGTH_PRECISION_CREATED_DATE = 6;
	public static final int LENGTH_PRECISION_LAST_MODIFIED_DATE = 6;
	public static final int LENGTH_PRECISION_START_DATE = 6;
	public static final int LENGTH_PRECISION_END_DATE = 6;

	// COLUMN NAMES //
	public static final String BASE_MODEL_NAME_ID_COLUMN = "id";
	public static final String BASE_NAME_MODEL_NAME_NAME_COLUMN = "name";
	public static final String BASE_NAME_MODEL_NAME_DESCRIPTION_COLUMN = "description";
	public static final String BASE_CODE_MODEL_NAME_CODE_COLUMN = "code";
	public static final String BASE_AUDIT_MODEL_NAME_CREATED_BY_COLUMN = "created_by";
	public static final String BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN = "created_date";
	public static final String BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_COLUMN = "last_modify_by";
	public static final String BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN = "last_modified_date";
	public static final String BASE_LOCALIZED_MODEL_LOCALE_COLUMN = "locale";
	public static final String BASE_LOCALIZED_MODEL_NAME_FIELD_NAME_COLUMN = "field_name";
	public static final String BASE_LOCALIZED_MODEL_NAME_VALUE_COLUMN = "value";
	public static final String BASE_START_END_DATE_MODEL_NAME_START_DATE_COLUMN = "start_date";
	public static final String BASE_START_END_DATE_MODEL_NAME_END_DATE_COLUMN = "end_date";

	// DEFAULT VALUES //
	public static final String BASE_AUDIT_MODEL_NAME_CREATED_DATE_COLUMN_DEFAULT_VALUE = "DATETIME("
			+ LENGTH_PRECISION_CREATED_DATE + ") DEFAULT CURRENT_TIMESTAMP(" + LENGTH_PRECISION_CREATED_DATE + ")";
	public static final String BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_COLUMN_DEFAULT_VALUE = "DATETIME("
			+ LENGTH_PRECISION_LAST_MODIFIED_DATE + ") DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP("
			+ LENGTH_PRECISION_LAST_MODIFIED_DATE + ")";
	public static final String BASE_START_END_DATE_MODEL_NAME_START_DATE_COLUMN_DEFAULT_VALUE = "DATETIME("
			+ LENGTH_PRECISION_START_DATE + ") DEFAULT CURRENT_TIMESTAMP(" + LENGTH_PRECISION_START_DATE + ")";

	// LOCALIZED_DATA //
	public static final String REPOSITORY_LOCALIZED_NAME_TABLE_NAME = "localized_" + BASE_NAME_MODEL_NAME_NAME_COLUMN + "_";
	public static final String REPOSITORY_LOCALIZED_NAME_ENTITY_NAME = "LocalizedName";
	public static final String REPOSITORY_LOCALIZED_DESCRIPTION_TABLE_NAME = "localized_" + BASE_NAME_MODEL_NAME_DESCRIPTION_COLUMN + "_";
	public static final String REPOSITORY_LOCALIZED_DESCRIPTION_ENTITY_NAME = "LocalizedDescription";
	
	// JPA QUERY OBJECTS NAMES //
	public static final String BASE_NAME_MODEL_OBJECT_JPA = "name";
	public static final String BASE_DESCRIPTION_MODEL_OBJECT_JPA = "description";
	public static final String BASE_CODE_MODEL_OBJECT_JPA = "code";
	public static final String BASE_AUDIT_MODEL_OBJECT_JPA = "auditData";

	// JPA FIELD NAMES //
	public static final String BASE_MODEL_NAME_ID_JPA = "id";
	public static final String BASE_NAME_MODEL_NAME_JPA = "name";
	public static final String BASE_NAME_MODEL_DESCRIPTION_JPA = "description";
	public static final String BASE_CODE_MODEL_CODE_JPA = "code";
	public static final String BASE_AUDIT_MODEL_NAME_CREATED_BY_JPA = "createdBy";
	public static final String BASE_AUDIT_MODEL_NAME_CREATED_DATE_JPA = "createdDate";
	public static final String BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_JPA = "lastModifiedBy";
	public static final String BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_JPA = "lastModifiedDate";
	public static final String BASE_LOCALIZED_MODEL_LOCALE_JPA = "embeddedId." + BASE_LOCALIZED_MODEL_LOCALE_COLUMN;

	// JPA QUERY FIELD NAMES //
	// BASE NAME MODEL //
	public static final String BASE_NAME_MODEL_OBJECT_NAME_JPA = BASE_NAME_MODEL_OBJECT_JPA + "."
			+ BASE_NAME_MODEL_NAME_JPA;

	public static final String BASE_DESCRIPTION_MODEL_OBJECT_DESCRIPTION_JPA = BASE_DESCRIPTION_MODEL_OBJECT_JPA + "."
			+ BASE_NAME_MODEL_DESCRIPTION_JPA;

	public static final String BASE_NAME_MODEL_OBJECT_DESCRIPTION_JPA = BASE_DESCRIPTION_MODEL_OBJECT_DESCRIPTION_JPA;

	// BASE CODE MODEL //
	public static final String BASE_CODE_MODEL_OBJECT_CODE_JPA = BASE_CODE_MODEL_OBJECT_JPA + "."
			+ BASE_CODE_MODEL_CODE_JPA;
	public static final String BASE_CODE_MODEL_OBJECT_DESCRIPTION_JPA = BASE_DESCRIPTION_MODEL_OBJECT_DESCRIPTION_JPA;

	// BASE AUDIT MODEL //
	public static final String BASE_AUDIT_MODEL_OBJECT_CREATED_BY_JPA = BASE_AUDIT_MODEL_OBJECT_JPA + "."
			+ BASE_AUDIT_MODEL_NAME_CREATED_BY_JPA;
	public static final String BASE_AUDIT_MODEL_OBJECT_CREATED_DATE_JPA = BASE_AUDIT_MODEL_OBJECT_JPA + "."
			+ BASE_AUDIT_MODEL_NAME_CREATED_DATE_JPA;
	public static final String BASE_AUDIT_MODEL_OBJECT_LAST_MODIFY_BY_JPA = BASE_AUDIT_MODEL_OBJECT_JPA + "."
			+ BASE_AUDIT_MODEL_NAME_LAST_MODIFY_BY_JPA;
	public static final String BASE_AUDIT_MODEL_OBJECT_LAST_MODIFIED_DATE_JPA = BASE_AUDIT_MODEL_OBJECT_JPA + "."
			+ BASE_AUDIT_MODEL_NAME_LAST_MODIFIED_DATE_JPA;

	// BASE CODE MODEL AUDIT DATA //
	public static final String BASE_CODE_MODEL_OBJECT_AUDIT_CREATED_BY_JPA = BASE_AUDIT_MODEL_OBJECT_CREATED_BY_JPA;
	public static final String BASE_CODE_MODEL_OBJECT_AUDIT_CREATED_DATE_JPA = BASE_AUDIT_MODEL_OBJECT_CREATED_DATE_JPA;
	public static final String BASE_CODE_MODEL_OBJECT_AUDIT_LAST_MODIFY_JPA = BASE_AUDIT_MODEL_OBJECT_LAST_MODIFY_BY_JPA;
	public static final String BASE_CODE_MODEL_OBJECT_AUDIT_LAST_MODIFIED_DATE_JPA = BASE_AUDIT_MODEL_OBJECT_LAST_MODIFIED_DATE_JPA;

}
