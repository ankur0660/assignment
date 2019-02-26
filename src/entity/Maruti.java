/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public final class Maruti extends Car {

    public Maruti(String model, int carId, int price) {
        this.model = model;
        type = "Maruti";
        this.id = carId;
        this.price = price;

    }

    @Override
    public Double resaleValue() {

        /*resale value=60% of price
      @return resale value
         */
        return price * 0.6;
    }
}
