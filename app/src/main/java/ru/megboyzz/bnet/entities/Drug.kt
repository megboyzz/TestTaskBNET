package ru.megboyzz.bnet.entities

data class Drug(
    val id: Int,
    val image: String,
    val categories: DrugsCategories?,
    val name: String,
    val description: String,
    val documentation: String,
    val fields: List<Field>?

)