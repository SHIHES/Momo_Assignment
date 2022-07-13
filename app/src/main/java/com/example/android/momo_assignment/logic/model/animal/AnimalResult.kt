package com.example.android.momo_assignment.logic.model.animal

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimalResult(
    @SerializedName("result")
    val result: Result
) : Parcelable