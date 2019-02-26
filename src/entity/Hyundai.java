/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public final class Hyundai extends Car {

    public Hyundai(String model, int carId, int price) {

        type = "Hyundai";
        this.model = model;
        this.id = carId;
        this.price = price;

    }

    @Override
    public Double resaleValue() {
        /*resale value=40% of price
      @return resale value
         */
        return price * 0.4;
    }
}
