package com.news.mvcnewsapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.news.mvcnewsapp.models.Api
import com.news.mvcnewsapp.models.NewsGetSet
import com.news.mvcnewsapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.news.mvcnewsapp.models.Articles
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news.mvcnewsapp.databinding.ActivityFullBinding
import com.news.mvcnewsapp.databinding.ActivityMainBinding
import com.news.mvcnewsapp.models.RecylerViewAdapter


class MainActivity : AppCompatActivity() {

    private var adapter: RecylerViewAdapter? = null
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.news.mvcnewsapp.R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, com.news.mvcnewsapp.R.layout.activity_main)

        getrewsItem()
    }


    fun getrewsItem() {


        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)

        val mapdata = HashMap<String, String>()
        mapdata.put("apiKey", "2352d41b50804fcebefbbe2fde7d8b13")
        mapdata.put("Country", "us")

        var call = api.getnews(mapdata) as Call<NewsGetSet>

        call.enqueue(object : Callback<NewsGetSet> {
            override fun onResponse(call: Call<NewsGetSet>, response: Response<NewsGetSet>) {
                Log.d("LogdgetTitle: ", response.body().toString())
                Log.d("Logdresponse.code(): ", response.toString())
                if (response.code() == 200) {
                    Log.d("Logdresponse.200): ", "")
                    //Creating an String array for the ListView
                    val jsonResponse = response.body() as NewsGetSet
                    var list = jsonResponse.getArticles() as ArrayList<Articles>

                    adapter = RecylerViewAdapter(applicationContext, list);
                    binding.recyclerview?.layoutManager = LinearLayoutManager(applicationContext)
                    binding.recyclerview?.adapter = adapter
                    binding.recyclerview?.setAdapter(adapter);
                    Log.d("Logdresponse.200): ", jsonResponse.getArticles()?.size.toString())
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }

            }

            override
            fun onFailure(call: Call<NewsGetSet>, t: Throwable) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("LogdThrowable: ", t.toString())
            }
        });
    }

}

