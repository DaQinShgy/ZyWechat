package com.goldze.mvvmhabit.entity;

import org.litepal.crud.LitePalSupport;

public class BankCard extends LitePalSupport {

    private String name;

    private String type;

    private String no;

    private int drawable;

    public BankCard() {
    }

    public BankCard(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
