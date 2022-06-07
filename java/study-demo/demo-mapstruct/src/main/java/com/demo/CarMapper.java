package com.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author ying.zhang01
 */
@Mapper
public interface CarMapper {

    @Mapping(source = "make", target = "manufacturer")
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);

    @Mapping(source = "name", target = "fullName")
    PersonDto personToPersonDto(Person person);
}
