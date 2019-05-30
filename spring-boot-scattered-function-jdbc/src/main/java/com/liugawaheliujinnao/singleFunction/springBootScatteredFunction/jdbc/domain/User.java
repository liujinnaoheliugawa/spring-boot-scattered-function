package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.domain;

/**
 * @Description: 用户模型
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class User {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println("User Thread name is " + Thread.currentThread().getName());
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
