package com.example.myapplication.models;

import java.io.Serializable;

public class Items implements Serializable {
    private int itemImg;
    private String header;
    private String price;

    public Items(int itemImg, String header, String price) {
        this.itemImg = itemImg;
        this.header = header;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemImg=" + itemImg +
                ", header=" + header +
                '}';
    }
}
