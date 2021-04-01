///**
// * LocalizedNameDrinkDTOMappingContextConverter.java 21 mar. 2021
// *
// */
//package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//
//import org.modelmapper.Converter;
//import org.modelmapper.spi.MappingContext;
//import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedNameDrinkDTO;
//import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedNameDrink;
//
//import lombok.AccessLevel;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
///**
// * LocalizedNameDrinkDTOMappingContextConverter
// * 
// * @author juan.gonzalez.fernandez.jgf
// *
// */
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public final class LocalizedNameDrinkDTOMappingContextConverter
//		implements Converter<LocalizedNameDrink, LocalizedNameDrinkDTO> {
//
//	@NonNull
//	LocalizedNameDrinkDTOMapperConverter converter;
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Valid
//	@Override
//	public LocalizedNameDrinkDTO convert(
//			@NotNull final MappingContext<LocalizedNameDrink, LocalizedNameDrinkDTO> context) {
//		return converter.convert(context.getSource());
//	}
//}
