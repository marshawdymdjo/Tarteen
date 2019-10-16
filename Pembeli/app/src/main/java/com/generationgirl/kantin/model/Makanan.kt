package com.generationgirl.kantin.model

import android.os.Parcel
import android.os.Parcelable

data class Makanan(val namaMakanan: String? = "", val harga: String? = "") : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namaMakanan)
        parcel.writeString(harga)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Makanan> {
        override fun createFromParcel(parcel: Parcel): Makanan {
            return Makanan(parcel)
        }

        override fun newArray(size: Int): Array<Makanan?> {
            return arrayOfNulls(size)
        }
    }
}