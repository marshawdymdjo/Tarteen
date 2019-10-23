package com.generationgirl.kantin.model

import android.os.Parcel
import android.os.Parcelable

data class Pesanan(var total: String? = "", var kode: String? = "",
                   var daftarMakanan: List<Makanan>? = ArrayList()) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Makanan)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(total)
        parcel.writeString(kode)
        parcel.writeTypedList(daftarMakanan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pesanan> {
        override fun createFromParcel(parcel: Parcel): Pesanan {
            return Pesanan(parcel)
        }

        override fun newArray(size: Int): Array<Pesanan?> {
            return arrayOfNulls(size)
        }
    }

}