/**
 * IngredientRepository.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.ingredients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.sauces.Ingredient;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
