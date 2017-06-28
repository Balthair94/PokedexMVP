package baltamon.mx.pokedexmvp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */
class PokemonMove (val move: NamedAPIResource) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PokemonMove> = object : Parcelable.Creator<PokemonMove> {
            override fun createFromParcel(source: Parcel): PokemonMove = PokemonMove(source)
            override fun newArray(size: Int): Array<PokemonMove?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readParcelable<NamedAPIResource>(NamedAPIResource::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(move, 0)
    }
}