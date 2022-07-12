package com.example.android.momo_assignment.logic.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Building(
    @SerializedName("_id")
    val _id: Int,
    @SerializedName("_importdate")
    val _importdate: ImportDate,
    @SerializedName("e_category")
    val e_category: String,
    @SerializedName("e_geo")
    val e_geo: String,
    @SerializedName("e_info")
    val e_info: String,
    @SerializedName("e_memo")
    val e_memo: String,
    @SerializedName("e_name")
    val e_name: String,
    @SerializedName("e_no")
    val e_no: String,
    @SerializedName("e_pic_url")
    val e_pic_url: String,
    @SerializedName("e_url")
    val e_url: String
) : Parcelable