package com.etc.Ayy_collection.set_demo.card;

public class card_demo {
    // 这是一个card类
    private String number;
    private  String color;

    public card_demo(){

    }
    public card_demo(String number, String color){
        this.color = color;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return number + color ;
    }
}
