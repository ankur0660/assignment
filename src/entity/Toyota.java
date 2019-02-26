/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public final class Toyota extends Car {

   public Toyota(String model, int carId, int price) {
        this.model = model;
        this.id = carId;
        this.price = price;
        type = "toyota";

    }

    @Override
    public Double resaleValue() {

        /*resale value=80% of price
      @return resale value
         */
        return price * 0.8;
    }
}
