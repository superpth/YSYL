package com.PangTingHui.springboot01quick.entities;

public class TagReturnData {
    private Object word;
    private Integer num;
    private Integer id;

    public Object getWord() {
        return word;
    }

    public TagReturnData(String word, Integer num, Integer id) {
        this.word = word;
        this.num = num;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
