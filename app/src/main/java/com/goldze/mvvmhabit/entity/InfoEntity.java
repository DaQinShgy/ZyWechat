package com.goldze.mvvmhabit.entity;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by goldze on 2017/7/17.
 */

public class InfoEntity extends BaseObservable implements Parcelable {
    private String wxId;
    private String name;
    private String head;

    public InfoEntity() {
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public static Creator<InfoEntity> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wxId);
        dest.writeString(this.name);
        dest.writeString(this.head);
    }

    protected InfoEntity(Parcel in) {
        this.wxId = in.readString();
        this.name = in.readString();
        this.head = in.readString();
    }

    public static final Creator<InfoEntity> CREATOR = new Creator<InfoEntity>() {
        @Override
        public InfoEntity createFromParcel(Parcel source) {
            return new InfoEntity(source);
        }

        @Override
        public InfoEntity[] newArray(int size) {
            return new InfoEntity[size];
        }
    };
}
