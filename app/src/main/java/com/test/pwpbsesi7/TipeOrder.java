package com.test.pwpbsesi7;

import android.os.Parcel;
import android.os.Parcelable;

public class TipeOrder implements Parcelable {
    int id_image;
    String label_order;
    int order_color;
    int tipe_order;
    //getset
    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getLabel_order() {
        return label_order;
    }

    public void setLabel_order(String label_order) {
        this.label_order = label_order;
    }

    public int getOrder_color() {
        return order_color;
    }

    public void setOrder_color(int order_color) {
        this.order_color = order_color;
    }

    public int getTipe_order() {
        return tipe_order;
    }

    public void setTipe_order(int tipe_order) {
        this.tipe_order = tipe_order;
    }
    //constructor


    public TipeOrder() {
    }

    //parcel
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id_image);
        dest.writeString(this.label_order);
        dest.writeInt(this.order_color);
        dest.writeInt(this.tipe_order);
    }

    protected TipeOrder(Parcel in) {
        this.id_image = in.readInt();
        this.label_order = in.readString();
        this.order_color = in.readInt();
        this.tipe_order = in.readInt();
    }

    public static final Parcelable.Creator<TipeOrder> CREATOR = new Parcelable.Creator<TipeOrder>() {
        @Override
        public TipeOrder createFromParcel(Parcel source) {
            return new TipeOrder(source);
        }

        @Override
        public TipeOrder[] newArray(int size) {
            return new TipeOrder[size];
        }
    };
}
