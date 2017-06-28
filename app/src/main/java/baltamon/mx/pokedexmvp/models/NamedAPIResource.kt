package baltamon.mx.pokedexmvp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class NamedAPIResource(val name: String, val url: String) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<NamedAPIResource> = object : Parcelable.Creator<NamedAPIResource> {
            override fun createFromParcel(source: Parcel): NamedAPIResource = NamedAPIResource(source)
            override fun newArray(size: Int): Array<NamedAPIResource?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(url)
    }
}