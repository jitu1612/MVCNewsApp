package com.news.mvcnewsapp.models

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList
import android.content.Intent
import com.news.mvcnewsapp.Views.FullActivity


class RecylerViewAdapter (val context: Context, var newsList: ArrayList<Articles>) : RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder>() {
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(com.news.mvcnewsapp.R.layout.single,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvtitle.text = newsList.get(position).getTitle()
        holder.tvdate.text = getCurrentDate(newsList.get(position).getPublishedAt())
        Glide.with(context).load(newsList.get(position).getUrlToImage())
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
        holder.image.setOnClickListener {
           // Log.i("logd: "+position,newsList.get(position).getContent())
            val i = Intent(context, FullActivity::class.java)
            i.putExtra("title", newsList.get(position).getTitle())
            i.putExtra("author", newsList.get(position).getAuthor())
            i.putExtra("date",getCurrentDate(newsList.get(position).getPublishedAt()))
            i.putExtra("image", newsList.get(position).getUrlToImage())
            i.putExtra("url", newsList.get(position).getUrl())
            i.putExtra("content", newsList.get(position).getContent())
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    fun setnewsListItems(newsList: ArrayList<Articles>){
        this.newsList = newsList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvtitle: TextView = itemView!!.findViewById(com.news.mvcnewsapp.R.id.title)
        val tvdate: TextView = itemView!!.findViewById(com.news.mvcnewsapp.R.id.date)
        val image: ImageView = itemView!!.findViewById(com.news.mvcnewsapp.R.id.image)

    }

    fun getCurrentDate(date:String?): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd MMM yy hh:mm a")
        //dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val output = formatter.format(dateFormat.parse(date))
        return output
    }
}