/**
 * JPAAuditDataConfiguration.java 25 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.datasource;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JPAAuditDataConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAuditDataProvider")
public class JPAAuditDataConfiguration {
	
	
	@Bean
    public AuditorAware<String> auditorAuditDataProvider() {
        return new JPAAuditorAuditDataAwareImpl();
    }


    public class JPAAuditorAuditDataAwareImpl implements AuditorAware<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.ofNullable("root-mbapp");
        }
    }
	
}
