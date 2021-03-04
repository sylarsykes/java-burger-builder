/**
 * ModelMapperFunction.java 31 ene. 2021
 *
 */
package org.sylrsykssoft.springboot.common.util.mapper;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/**
 * Mapper entity to resource or resource to entity.
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @param <T> the generic type
 * @param <R> the generic type
 *
 */
@Slf4j
public class ModelMapperFunction<T, R> implements Function<T, R> {

	private static final String LOG_CLASS_NAME = ModelMapperFunction.class.getSimpleName() + ".";

    private static final String LOG_CLASS_APPLY_METHOD_NAME = LOG_CLASS_NAME
            + "apply - Map input object to result object - ";
	
	@Autowired
	ModelMapper modelMapper;
	
	ModelMapperDTO<R> result;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public R apply(final T source) {
		LOGGER.info("{} Mapper a soruce {}", LOG_CLASS_APPLY_METHOD_NAME, source);
		
		final R target = modelMapper.map(source, result.getTargetClass());
		
		LOGGER.info("{} Result -> {}", LOG_CLASS_APPLY_METHOD_NAME, target);
		
		return target;
	}

}
