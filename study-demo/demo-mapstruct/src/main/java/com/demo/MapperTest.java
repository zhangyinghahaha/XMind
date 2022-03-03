package com.demo;

import org.mapstruct.factory.Mappers;

/**
 * @author ying.zhang01
 */
public class MapperTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("大众");
        car.setNumberOfSeats(4);

        CarMapper carMapper = Mappers.getMapper(CarMapper.class);
        CarDto carDto = carMapper.carToCarDto(car);
        System.out.println(carDto);
    }
}
