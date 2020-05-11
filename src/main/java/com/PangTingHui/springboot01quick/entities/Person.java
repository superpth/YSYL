package com.PangTingHui.springboot01quick.entities;

public class Person implements Cloneable{
    private String name;
    private Integer id;
    private Children children;

    public String getName() {
        return name;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
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

    public Person() {
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();
        clone.setChildren(children.clone());
        return clone;
    }
}
