package com.example.android.momo_assignment.logic.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ImportDate(
    @SerializedName("date")
    val date: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_type")
    val timezone_type: Int
) : Parcelable