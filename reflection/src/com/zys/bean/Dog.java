package com.zys.bean;

public class Dog {

    private String name;

    public Dog(){
        this.name = "汪汪";
    }

    public Dog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println(name + " say 汪汪汪~");
    }

    public void eat(){
        System.out.println(name + "在吃东西");
    }

    public void play(){

    }
}
