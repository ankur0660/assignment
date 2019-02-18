
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
*
 * @author ankur
 */
class Customer implements Comparable<Customer>{
    
int id;String name;
final ArrayList<Car> CARS;

    public Customer(int id,String name,ArrayList<Car> CARS) {
        this.id=id;
        this.name=name;
        this.CARS=(ArrayList<Car>)CARS.clone();
        
        
    
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
