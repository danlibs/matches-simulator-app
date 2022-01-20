package com.danlibs.soccersimulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("name")
    val name: String,
    @SerializedName("strength")
    val strength: Int,
    @SerializedName("image")
    val image: String,
    var score: Int?,
    @SerializedName("players")
    val players: Array<String>
) : Parcelable