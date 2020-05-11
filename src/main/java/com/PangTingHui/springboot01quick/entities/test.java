package com.PangTingHui.springboot01quick.entities;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("J");
        Children children = new Children();
        children.setName("J-children");
        children.setId(1);
        p1.setChildren(children);

        Person p2 = p1.clone();

        System.out.println(p1.hashCode()+"~~"+p1.getChildren().hashCode());
        System.out.println(p2.hashCode()+"~~"+p2.getChildren().hashCode());
    }
}
