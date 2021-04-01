///**
// * LocalizedNameDrinkDTOMapperConverter.java 20 mar. 2021
// *
// */
//package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//
//import org.modelmapper.Converters.Converter;
//import org.modelmapper.ModelMapper;
//import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedNameDrinkDTO;
//import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedNameDrink;
//import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
//import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;
//
//import lombok.AccessLevel;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
///**
// * LocalizedNameDrinkDTOMapperConverter
// * 
// * @author juan.gonzalez.fernandez.jgf
// *
// */
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public final class LocalizedNameDrinkDTOMapperConverter
//		implements Converter<LocalizedNameDrink, LocalizedNameDrinkDTO> {
//
//	@NonNull
//	ModelMapper commonModelMapper;
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	@Valid
//	public LocalizedNameDrinkDTO convert(@NotNull @Valid final LocalizedNameDrink source) {
//		final LocalizedFieldNameModelDTO localizedId = commonModelMapper.map(source.getEmbeddedId(),
//				LocalizedFieldNameModelDTO.class);
//		final LocalizedValueModelDTO value = commonModelMapper.map(source.getValue(), LocalizedValueModelDTO.class);
//
//		return LocalizedNameDrinkDTO.builder().embeddedId(localizedId).value(value).build();
//	}
//}
