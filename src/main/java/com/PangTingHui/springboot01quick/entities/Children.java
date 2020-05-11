package com.PangTingHui.springboot01quick.entities;

public class Children implements Cloneable{
    private String name;
    private Integer id;

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Children() {
    }

    public Children(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected Children clone() throws CloneNotSupportedException {
        return (Children) super.clone();
    }
}
