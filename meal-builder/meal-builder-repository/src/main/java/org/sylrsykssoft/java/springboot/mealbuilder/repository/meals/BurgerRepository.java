/**
 * BurgerFindRepository.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.BurgerApiConstants.REPOSITORY_BURGER_ENTITY_NAME;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals.Burger;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface BurgerRepository extends JpaRepository<Burger, Long> {
	
	/**
	 * Find burger by name
	 * 
	 * @param name Name
	 * @return Optional<Burger>
	 */
	@Query("SELECT b FROM " + REPOSITORY_BURGER_ENTITY_NAME	+ " b WHERE b.name = :name")
	Optional<Burger> findByName(@Param("name") String name);
	
}
