package com.example.despensa

import android.os.Parcel
import android.os.Parcelable

data class Producto(
                    val nombre: String?,
                    val tienda: String?,
                    val precio: String?,
                    val cantidad: String?,
                    val cantegoria: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(tienda)
        parcel.writeString(precio)
        parcel.writeString(cantidad)
        parcel.writeString(cantegoria)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }
}