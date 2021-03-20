/**
 * FileQueryConfigurationProperties.java 17 mar. 2021
 * 
 */
package org.sylrsykssoft.springboot.common.app.boot.configuration.properties.datasource.filequery;

import static org.springframework.core.io.support.ResourcePatternUtils.getResourcePatternResolver;
import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_FILE_QUERIES;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * ConfigurationProperties bean
 *
 * Defines the properties for loading the file(s) with the project queries.
 *
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ConfigurationProperties(prefix = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_FILE_QUERIES)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class FileQueryConfigurationProperties {

    String beanName;

    String beanNameProperties;

    String fileQueriesResourceName;

    /**
     * Load bean.
     * @param resourceLoader the resource loader
     * @param resource the resource
     * @return the properties factory bean
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public PropertiesFactoryBean loadBean(final ResourceLoader resourceLoader, final String resource)
            throws IOException {
        final PropertiesFactoryBean bean = new PropertiesFactoryBean();
        
        final Resource[] resources = getResourcePatternResolver(resourceLoader).getResources(resource);
        bean.setLocations(resources);
        bean.setIgnoreResourceNotFound(true);
        bean.afterPropertiesSet();
        
        final Properties props = bean.getObject();

        if (props != null) {
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                final String key = (String) entry.getKey();
                final String prop = (String) entry.getValue();
                props.put(key, prop);
            }

            bean.setLocalOverride(true);
            bean.setProperties(props);
            bean.afterPropertiesSet();
        }

        return bean;
    }

}
