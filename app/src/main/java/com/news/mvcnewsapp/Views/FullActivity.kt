package com.news.mvcnewsapp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import androidx.databinding.DataBindingUtil
import com.news.mvcnewsapp.databinding.ActivityFullBinding


class FullActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(com.news.mvcnewsapp.R.layout.activity_full)
        var binding : ActivityFullBinding = DataBindingUtil.setContentView(this, com.news.mvcnewsapp.R.layout.activity_full)


        val i = intent
        binding.title.setText(i.getStringExtra("title"));
        binding.author.setText(i.getStringExtra("author"));
        binding.date.setText(i.getStringExtra("date"));
        binding.content.setText(i.getStringExtra("content"));

        Glide.with(applicationContext).load(i.getStringExtra("image"))
            .apply(RequestOptions().centerCrop())
            .into(binding.image)
        binding.link.setOnClickListener {
            Log.d("ugug", i.getStringExtra("url"))
            val i1 = Intent(applicationContext, WebActivity::class.java)
            i1.putExtra("url", i.getStringExtra("url"))
            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i1)
        }

    }
}
