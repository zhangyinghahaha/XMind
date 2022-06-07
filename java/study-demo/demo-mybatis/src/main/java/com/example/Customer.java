package com.example;

public class Customer {
    private int custId;
    private String custName;
    private String custEmail;

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }
}
