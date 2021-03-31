package id.smartdev.deproo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Source(
    val id: Int?,
    val name: String?
) : Parcelable