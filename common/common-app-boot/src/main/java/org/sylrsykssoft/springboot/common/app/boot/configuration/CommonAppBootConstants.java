/**
 * CommonAppBootConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration;

import lombok.experimental.UtilityClass;

/**
 * CommonAppBootConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class CommonAppBootConstants {

	// BASE //
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES = "common.app.boot.configuration";
	
	// DATASOURCE //
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES + ".datasource";
	
	// SPRINGDOC //
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES + ".springdoc";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_ADMIN_API = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC + ".admin-api";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_OPEN_API = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC + ".open-api";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_PUBLIC_API = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC + ".public-api";

	// JASYPT //
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES + ".jasypt";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_SIMPLEPBE = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT + ".simple";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_WEBPBE = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT + ".web";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_BASIC = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT + ".util.text.basic";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT_UTIL_TEXT_STRONG = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_JASYPT + ".util.text.strong";
	
}
