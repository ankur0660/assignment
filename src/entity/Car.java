/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/*general template for cars */
public abstract class Car {

    protected String type;
    protected String model;
    protected int id;
    protected int price;

   public abstract Double resaleValue();

   public String getType()
    {
        return type;
    }

    public int getId() {
        return id;
    }

   public String getModel() {
        return model;
    }

   public int getPrice() {
        return price;
    }

}
