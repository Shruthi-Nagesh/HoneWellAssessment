package com.example.data


import android.os.Parcel
import android.os.Parcelable

data class CartItems(val productName: String?, val priceTag: String?,val isOfferAvailable: Boolean, val offer: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productName)
        parcel.writeString(priceTag)
        parcel.writeByte(if (isOfferAvailable) 1 else 0)
        parcel.writeString(offer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CartItems> {
        override fun createFromParcel(parcel: Parcel): CartItems {
            return CartItems(parcel)
        }

        override fun newArray(size: Int): Array<CartItems?> {
            return arrayOfNulls(size)
        }
    }
}
