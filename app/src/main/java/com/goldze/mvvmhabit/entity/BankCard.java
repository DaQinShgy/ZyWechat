package com.goldze.mvvmhabit.entity;

import org.litepal.crud.LitePalSupport;

public class BankCard extends LitePalSupport {

    private String name;

    private String type;

    private String no;

    private int drawable0;

    private int drawable1;

    private int drawable2;

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

    public int getDrawable0() {
        return drawable0;
    }

    public void setDrawable0(int drawable0) {
        this.drawable0 = drawable0;
    }

    public int getDrawable1() {
        return drawable1;
    }

    public void setDrawable1(int drawable1) {
        this.drawable1 = drawable1;
    }

    public int getDrawable2() {
        return drawable2;
    }

    public void setDrawable2(int drawable2) {
        this.drawable2 = drawable2;
    }
}
