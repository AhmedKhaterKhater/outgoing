package com.example.CMSCrud.model;

public class Customer implements Comparable<Customer> {

    private String name;
    public Customer(String s) {
        this.name = s;
    }

    @Override
    public int compareTo(Customer other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
