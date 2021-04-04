/**
 * DrinkFindRepository.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query.DrinkQueryFindRepository.REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM;
import static org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query.DrinkQueryFindRepository.REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME_PARAM;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkLocalizationDataModelDTO;

/**
 * DrinkRepository
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see <a href="META-INF/drinks-mapping/drink.orm.xml">Repository queries</a>
 *
 */
@Repository
@RepositoryDefinition(domainClass = Drink.class, idClass = Long.class)
public interface DrinkRepository extends JpaRepository<Drink, Long> {
	
	/**
	 * Insert drink localized data
	 * @param localizedData Localized data
	 * @return int
	 */
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO drinks.localized_drink"
			+ "(drink_id, locale, field_name, value) "
			+ "VALUES("
			+ ":#{#localizedData.id}, :#{#localizedData.embeddedId.locale}, :#{#localizedData.embeddedId.fieldName}, :#{#localizedData.value.value}"
			+ ")", nativeQuery = true)
	int insertLocalizationData(@NotNull @Valid @Param("localizedData") CreateDrinkLocalizationDataModelDTO localizedData);
	
	/**
	 * Find drink by name
	 * 
	 * @param name Name
	 * @return Optional<Drink>
	 * @see <a href="META-INF/drinks-mapping/drink.orm.xml">REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME</a>
	 */
	Optional<Drink> findByName(@Param(REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM) @NotBlank final String name);
	
	// NAME LIKE METHODS
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Drink> findByNameContaining(@Param(REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM) @NotBlank final String name);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Drink> findByNameContains(@Param(REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM) @NotBlank final String name);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Drink> findByNameIsContaining(@Param(REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM) @NotBlank final String name);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Drink> findByNameLike(@Param(REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM) @NotBlank final String name);
	
	/**
	 * Find drink by name
	 * 
	 * @param name Name
	 * @return Optional<Drink>
	 * @see <a href="META-INF/drinks-mapping/drink.orm.xml">REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME</a>
	 */
	Optional<Drink> findByType(@Param(REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME_PARAM) @NotBlank final String type);
	
}
