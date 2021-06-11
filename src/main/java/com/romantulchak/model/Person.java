package com.romantulchak.model;

import com.romantulchak.linq.Persistable;

public class Person implements Persistable {

    private String name;

    private long age;

    private short height;

    private byte memory;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public byte getMemory() {
        return memory;
    }

    public void setMemory(byte memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", memory=" + memory +
                '}';
    }
}
