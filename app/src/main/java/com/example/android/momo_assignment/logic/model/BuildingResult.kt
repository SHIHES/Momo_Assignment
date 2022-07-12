package com.example.android.momo_assignment.logic.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class BuildingResult(
    @SerializedName("result")
    val result: Result
) : Parcelable