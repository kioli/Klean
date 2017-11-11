package kioli.clean.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class QuoteModel(val text: String) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(text)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<QuoteModel> = object : Parcelable.Creator<QuoteModel> {
            override fun createFromParcel(source: Parcel): QuoteModel = QuoteModel(source)
            override fun newArray(size: Int): Array<QuoteModel?> = arrayOfNulls(size)
        }
    }
}