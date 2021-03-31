package id.smartdev.deproo.util

import android.content.Context
import androidx.preference.PreferenceManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object Helper {
    fun getBool(key: String, context: Context): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getBoolean(key, false)
    }

    fun saveBool(key: String, value: Boolean?, context: Context?) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }

    fun getString(key: String?, context: Context, defaults: String?): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(key, defaults)
    }

    fun saveString(key: String?, value: String?, context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getInteger(key: String, context: Context, valueDef: Int): Int {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getInt(key, valueDef)
    }

    fun saveInteger(key: String, value: Int?, context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putInt(key, value!!)
        editor.apply()
    }

    fun hasInternetConnection(): Single<Boolean> {
        return Single.fromCallable {
            try {
                val timeoutMs = 1500
                val socket = Socket()
                val socketAddress = InetSocketAddress("8.8.8.8", 53)

                socket.connect(socketAddress, timeoutMs)
                socket.close()

                true
            } catch (e: IOException) {
                false
            }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    val requestOperation = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .signature(ObjectKey("4f8d14bb3054db47faf293ab1d459ac9"))
        .override(500)

    val requestSmall = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .signature(ObjectKey("4f8d14bb3054db47faf293ab1d459ac9"))
        .override(200)

    fun validateEmail(email: String): Boolean {
        val emailPattern =
            Regex("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})\$")
        return email.matches(emailPattern)
    }
}