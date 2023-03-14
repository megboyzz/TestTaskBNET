package ru.megboyzz.bnet.entities

data class Field(
    val type: FieldType,
    val name: String,
    val value: String,
    val image: String,
    val flags: FieldsFlags?,
    val show: Int,
    val group: Int
)
