package ru.megboyzz.bnet.entities

import com.google.gson.annotations.SerializedName

enum class FieldType {
    @SerializedName("text")
    Text,
    @SerializedName("image")
    Image,
    @SerializedName("gallery")
    Gallery,
    @SerializedName("text_block")
    TextBlock,
    @SerializedName("list")
    List,
    @SerializedName("button")
    Button;
}