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
	
	
	// SPRINGDOC //
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES + ".springdoc";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_ADMIN_API = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC + ".admin-api";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_OPEN_API = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC + ".open-api";
	public static final String COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC_PUBLIC_API = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_SPRING_DOC + ".public-api";

}
