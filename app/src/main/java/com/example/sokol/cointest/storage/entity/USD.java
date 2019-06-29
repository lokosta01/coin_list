package com.example.sokol.cointest.storage.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USD implements Parcelable {

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    public String price;

    @ColumnInfo(name = "volume_24h")
    @SerializedName("volume_24h")
    @Expose
    public String volume_24h;

    public USD() {}

    protected USD(Parcel in) {
        price = in.readString();
        volume_24h = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(price);
        dest.writeString(volume_24h);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<USD> CREATOR = new Creator<USD>() {
        @Override
        public USD createFromParcel(Parcel in) {
            return new USD(in);
        }

        @Override
        public USD[] newArray(int size) {
            return new USD[size];
        }
    };

    public String getPrice() {
        return price;
    }

    public String getVolume_24h() {
        return volume_24h;
    }
}
