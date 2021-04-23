package com.zys.bean;

public class Cat {

    private String name;

    public Cat(){
        this.name = "猫猫";
    }

    public Cat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println(name + " say 喵喵喵~");
    }

    public void eat(){
        System.out.println(name + "在吃东西");
    }

    public void play(){

    }
}
