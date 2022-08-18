package com.example.cardealership.DataModels;

import android.os.Parcel;
import android.os.Parcelable;

/** Класс, представляющий автомобиль */
public class CarModel implements Parcelable {
    private String name;
    private int year;
    private double volume;
    private GearType gearType;
    private int power;
    private int price;
    private int previewId;
    private int imageId;

    public CarModel(String name,
                    int year,
                    double volume,
                    GearType gearType,
                    int power,
                    int price,
                    int previewId,
                    int imageId) {
        this.name = name;
        this.year = year;
        this.volume = volume;
        this.gearType = gearType;
        this.power = power;
        this.price = price;
        this.previewId = previewId;
        this.imageId = imageId;
    }

    protected CarModel(Parcel in) {
        this.name = in.readString();
        this.year = in.readInt();
        this.volume = in.readDouble();
        this.gearType = GearType.valueOf(in.readString());
        this.power = in.readInt();
        this.price = in.readInt();
        this.previewId = in.readInt();
        this.imageId = in.readInt();
    }

    public static final Creator<CarModel> CREATOR = new Creator<CarModel>() {
        @Override
        public CarModel createFromParcel(Parcel in) { return new CarModel(in); }

        @Override
        public CarModel[] newArray(int size) { return new CarModel[size]; }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeInt(year);
        parcel.writeDouble(volume);
        parcel.writeString(gearType.name());
        parcel.writeInt(power);
        parcel.writeInt(price);
        parcel.writeInt(previewId);
        parcel.writeInt(imageId);
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPreviewId() {
        return previewId;
    }

    public int getPrice() {
        return price;
    }

    public double getVolume() {
        return volume;
    }

    public GearType getGearType() {
        return gearType;
    }

    public int getPower() {
        return power;
    }

    public int getImageId() {
        return imageId;
    }
}
