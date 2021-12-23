package com.wipro.testapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wipro.testapp.R
import com.wipro.testapp.model.ResultsItem
import com.bumptech.glide.Glide

class FactsAdapter (private val mContext: Context, private val factlist: List<ResultsItem?>) : RecyclerView.Adapter<FactsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)    }

    override fun getItemCount(): Int {
        return factlist!!.size
    }

    override fun onBindViewHolder(holder: FactsAdapter.MyViewHolder, position: Int) {
        if(factlist[position]!!.factName != null) {
            holder.idTVFactTitle.setText(factlist[position]!!.factName)
            holder.idTVDes.setText(factlist[position]!!.factDesc)
            Glide.with(mContext).load(factlist[position]!!.factImgUrl).into(holder.idIVFact)
        }
    }

    inner class MyViewHolder (view: View) :RecyclerView.ViewHolder(view) {
        var idIVFact: ImageView = view.findViewById<View>(R.id.idIVfact) as ImageView
        var idTVFactTitle : TextView = view.findViewById<View>(R.id.idTVFactTitle) as TextView
        var idTVDes : TextView = view.findViewById<View>(R.id.idTVDes) as TextView
    }

}