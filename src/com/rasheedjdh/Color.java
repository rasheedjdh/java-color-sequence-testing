package com.rasheedjdh;

public class Color {

    public static String RED = "red";
    public static String GREEN = "green";

    String name;
    int code;

    public Color(String name) {
        this.name = name;
        this.code = name.equals(RED)? 1: 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
