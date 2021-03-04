/**
 * DrinkFindRepository.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query.DrinkQueryFindRepository.REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query.DrinkQueryFindRepository.REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM;
import static org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query.DrinkQueryFindRepository.REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query.DrinkQueryFindRepository.REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME_PARAM;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;

/**
 * DrinkRepository
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RepositoryDefinition(domainClass = Drink.class, idClass = Long.class)
public interface DrinkRepository extends JpaRepository<Drink, Long> {
	
	/**
	 * Find drink by name
	 * 
	 * @param name Name
	 * @return Optional<Drink>
	 */
	@Query(name = REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME)
	Optional<Drink> findByName(@Param(REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM) @NotBlank final String name);
	
	/**
	 * Find drink by name
	 * 
	 * @param name Name
	 * @return Optional<Drink>
	 */
	@Query(name = REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME)
	Optional<Drink> findByType(@Param(REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME_PARAM) @NotBlank final String type);
	
}
