package com.example.sokol.cointest.storage.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote implements Parcelable {

    @Embedded(prefix = "usd_")
    @SerializedName("USD")
    @Expose
    public USD usd;

    public Quote() {}

    protected Quote(Parcel in) {
        usd = in.readParcelable(USD.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(usd, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Quote> CREATOR = new Creator<Quote>() {
        @Override
        public Quote createFromParcel(Parcel in) {
            return new Quote(in);
        }

        @Override
        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };

    public USD getUsd() {
        return usd;
    }

    public void setUsd(USD usd) {
        this.usd = usd;
    }
}

class BTC {

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    public String price;

    @ColumnInfo(name = "volume_24h")
    @SerializedName("volume_24h")
    @Expose
    public String volume_24h;

    public String getPrice() {
        return price;
    }

    public String getVolume_24h() {
        return volume_24h;
    }
}



