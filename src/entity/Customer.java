package entity;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {

    public int id;
    public String name;
    public final ArrayList<Car> CARS;

    public Customer(int id, String name, ArrayList<Car> CARS) {
        this.id = id;
        this.name = name;
        this.CARS = (ArrayList<Car>) CARS.clone();

    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Customer other) {
        System.out.println(this.name.compareTo(name));
        return this.name.compareTo(other.name);
    }

}
