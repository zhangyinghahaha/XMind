package com.demo;

/**
 * @author ying.zhang01
 */
public class Car {
    private String make;
    private int numberOfSeats;
    private int test;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
