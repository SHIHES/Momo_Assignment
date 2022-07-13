package com.example.android.momo_assignment.logic.model.building

import android.os.Parcelable
import com.example.android.momo_assignment.logic.model.building.Building
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Result(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Building>,
    @SerializedName("sort")
    val sort: String
) : Parcelable