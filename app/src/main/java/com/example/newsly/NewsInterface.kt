package com.example.newsly

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=apple&from=2022-07-26&to=2022-07-26&sortBy=popularity&apiKey=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "7681cdec48444b4ab0be2c5d3d060692"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>

    //https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1
}

object NewsServices{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}