package ru.megboyzz.bnet.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.megboyzz.bnet.entities.Drug

interface DrugsService {

    @GET("/api/ppp/item/")
    suspend fun getDrug(@Query("id") id: Int): Call<Drug>

    @GET("/api/ppp/index/")
    suspend fun getListOfDrugs(
        @Query("id")
        id: Int? = null,
        @Query("search")
        search: String? = null,
        @Query("crop_id")
        cropId: Int? = null,
        @Query("harmful_object_id")
        harmfulObjectId: Int? = null,
        @Query("ingredient_id")
        ingredientId: Int? = null,
        @Query("offset")
        offset: Int? = null,
        @Query("limit")
        limit: Int? = null,
    ): List<Drug>

}

fun getRetrofit(): Retrofit{
    return Retrofit.Builder()
        .baseUrl("http://shans.d2.i-partner.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

