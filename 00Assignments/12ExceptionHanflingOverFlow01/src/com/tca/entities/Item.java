package com.tca.entities;

import com.tca.exceptions.OverPriceException;

public class Item {
    private int itemCode;
    private String itemName;
    private double itemPrice;


    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        try{
            if(itemPrice > 9999){
                throw new OverPriceException("OverPriceException : Entered Price is Greater Than 9999 i.e "+ itemPrice);
            }
            this.itemPrice = itemPrice;
        }
        catch (OverPriceException ope){
            System.out.println(ope.getMessage()+"\nTaking default itemPrice 0 !!!");
            this.itemCode = 0;
        }
        catch (Exception e){
            System.out.println("Unknown Error "+e.getMessage());
        }
    }




    @Override
    public String toString() {
        return "Item{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
