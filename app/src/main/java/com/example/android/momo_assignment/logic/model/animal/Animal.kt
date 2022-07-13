package com.example.android.momo_assignment.logic.model.animal

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Animal(
    @SerializedName("_id")
    val _id: Int,
    @SerializedName("\uFEFFA_Name_Ch")
    val name: String,
    @SerializedName("A_Adopt")
    val A_Adopt: String,
    @SerializedName("A_AlsoKnown")
    val A_AlsoKnown: String,
    @SerializedName("A_Behavior")
    val A_Behavior: String,
    @SerializedName("A_CID")
    val A_CID: String,
    @SerializedName("A_Class")
    val A_Class: String,
    @SerializedName("A_Code")
    val A_Code: String,
    @SerializedName("A_Conservation")
    val A_Conservation: String,
    @SerializedName("A_Crisis")
    val A_Crisis: String,
    @SerializedName("A_Diet")
    val A_Diet: String,
    @SerializedName("A_Distribution")
    val A_Distribution: String,
    @SerializedName("A_Family")
    val A_Family: String,
    @SerializedName("A_Feature")
    val A_Feature: String,
    @SerializedName("A_Geo")
    val A_Geo: String,
    @SerializedName("A_Habitat")
    val A_Habitat: String,
    @SerializedName("A_Interpretation")
    val A_Interpretation: String,
    @SerializedName("A_Keywords")
    val A_Keywords: String,
    @SerializedName("A_Location")
    val A_Location: String,
    @SerializedName("A_Name_En")
    val A_Name_En: String,
    @SerializedName("A_Name_Latin")
    val A_Name_Latin: String,
    @SerializedName("A_Order")
    val A_Order: String,
    @SerializedName("A_POIGroup")
    val A_POIGroup: String,
    @SerializedName("A_Phylum")
    val A_Phylum: String,
    @SerializedName("A_Pic01_ALT")
    val A_Pic01_ALT: String,
    @SerializedName("A_Pic01_URL")
    val A_Pic01_URL: String,
    @SerializedName("A_Pic02_ALT")
    val A_Pic02_ALT: String,
    @SerializedName("A_Pic02_URL")
    val A_Pic02_URL: String,
    @SerializedName("A_Pic03_ALT")
    val A_Pic03_ALT: String,
    @SerializedName("A_Pic03_URL")
    val A_Pic03_URL: String,
    @SerializedName("A_Pic04_ALT")
    val A_Pic04_ALT: String,
    @SerializedName("A_Pic04_URL")
    val A_Pic04_URL: String,
    @SerializedName("A_Summary")
    val A_Summary: String,
    @SerializedName("A_Theme_Name")
    val A_Theme_Name: String,
    @SerializedName("A_Theme_URL")
    val A_Theme_URL: String,
    @SerializedName("A_Update")
    val A_Update: String,
    @SerializedName("A_Vedio_URL")
    val A_Vedio_URL: String,
    @SerializedName("A_Voice01_ALT")
    val A_Voice01_ALT: String,
    @SerializedName("A_Voice01_URL")
    val A_Voice01_URL: String,
    @SerializedName("A_Voice02_ALT")
    val A_Voice02_ALT: String,
    @SerializedName("A_Voice02_URL")
    val A_Voice02_URL: String,
    @SerializedName("A_Voice03_ALT")
    val A_Voice03_ALT: String,
    @SerializedName("A_Voice03_URL")
    val A_Voice03_URL: String,
    @SerializedName("A_pdf01_ALT")
    val A_pdf01_ALT: String,
    @SerializedName("A_pdf01_URL")
    val A_pdf01_URL: String,
    @SerializedName("A_pdf02_ALT")
    val A_pdf02_ALT: String,
    @SerializedName("A_pdf02_URL")
    val A_pdf02_URL: String
) : Parcelable