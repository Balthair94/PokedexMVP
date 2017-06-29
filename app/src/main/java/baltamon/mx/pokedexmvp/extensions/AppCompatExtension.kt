package baltamon.mx.pokedexmvp.extensions

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import baltamon.mx.pokedexmvp.R

/**
 * Created by Baltazar Rodriguez on 28/06/2017.
 */

fun Context.showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
fun Context.showLoadDialog() = ProgressDialog.show(this, getString(R.string.loading),
        "Loading, please wait...", true)
