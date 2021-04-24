package com.example.tugas4;

public class MainModel {
    Integer logo;
    String name, detail;

    public MainModel(Integer logo, String name, String detail) {
        this.logo = logo;
        this.name = name;
        this.detail = detail;
    }

    public Integer getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
}
