package com.example.appcityonfragments_l_6;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {

    private int imageIndex;
    private String name;

    public City(int imageIndex, String name) {
        this.imageIndex = imageIndex;
        this.name = name;
    }

    protected City(Parcel in) {
        imageIndex = in.readInt();
        name = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getImageIndex() {
        return imageIndex;
    }

    public String getName() {
        return name;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageIndex);
        parcel.writeString(name);
    }
}
