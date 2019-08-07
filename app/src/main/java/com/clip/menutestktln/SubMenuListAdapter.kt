package com.clip.menutestktln

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.sub_menu_list_layout.view.*

class SubMenuListAdapter(var c : Context, var lists : ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var v = LayoutInflater.from(c).inflate(R.layout.sub_menu_list_layout, p0, false)
        return Item(v)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as Item).bindData(lists[p1])
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(_list : String){
            itemView.subMenuButton.text = _list
        }
    }
}