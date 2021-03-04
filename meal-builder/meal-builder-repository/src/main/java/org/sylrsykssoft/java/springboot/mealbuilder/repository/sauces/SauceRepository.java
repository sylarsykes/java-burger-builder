/**
 * SauceFindRepository.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.sauces;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SauceApiConstants.REPOSITORY_SAUCE_ENTITY_NAME;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.sauces.Sauce;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface SauceRepository extends JpaRepository<Sauce, Long> {
	
	/**
	 * Find sauce by name
	 * 
	 * @param name Name
	 * @return Optional<Sauce>
	 */
	@Query("SELECT b FROM " + REPOSITORY_SAUCE_ENTITY_NAME	+ " b WHERE b.name = :name")
	Optional<Sauce> findByName(@Param("name") String name);
	
}
