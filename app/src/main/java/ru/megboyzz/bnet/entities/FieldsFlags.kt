package ru.megboyzz.bnet.entities

import com.google.gson.annotations.SerializedName


data class FieldsFlags(
    val html: Int,
    @SerializedName("no_value")
    val noValue: Int,
    @SerializedName("no_name")
    val noName: Int
)
