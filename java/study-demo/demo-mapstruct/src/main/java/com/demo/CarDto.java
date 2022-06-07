package com.demo;

/**
 * @author ying.zhang01
 */
public class CarDto {
    private String manufacturer;
    private int seatCount;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "manufacturer='" + manufacturer + '\'' +
                ", seatCount=" + seatCount +
                '}';
    }
}
