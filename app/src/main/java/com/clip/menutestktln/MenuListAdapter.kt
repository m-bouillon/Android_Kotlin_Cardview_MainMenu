package com.clip.menutestktln

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.menu_list_layout.view.*
import android.view.animation.RotateAnimation



class MenuListAdapter(var c : Context, var lists : ArrayList<MenuItemObject>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        var v = LayoutInflater.from(c).inflate(R.layout.menu_list_layout, p0, false)

        //Init the menu's closed
        v.rv_submenulist.visibility = View.GONE
        v.v_separation.visibility = View.GONE
        v.ib_unroll.animate().rotation(180f).withLayer().setDuration(0).start()

        v.ib_unroll.setOnClickListener {

            //Animate collapse menu
            val animationUp : Animation = AnimationUtils.loadAnimation(c, R.anim.slide_up)
            val animationDown : Animation = AnimationUtils.loadAnimation(c, R.anim.slide_down)

            if(v.rv_submenulist.visibility == View.VISIBLE){
                v.v_separation.startAnimation(animationUp)
                v.rv_submenulist.startAnimation(animationUp)
                v.ib_unroll.animate().rotation(180f).withLayer().setDuration(200).start()
                v.rv_submenulist.visibility = View.GONE
                v.v_separation.visibility = View.GONE
                TransitionManager.beginDelayedTransition(p0)

            }
            else{
                v.rv_submenulist.visibility = View.VISIBLE
                v.v_separation.visibility = View.VISIBLE
                v.rv_submenulist.startAnimation(animationDown)
                v.v_separation.startAnimation(animationDown)
                v.ib_unroll.animate().rotation(0f).withLayer().setDuration(200).start()
                TransitionManager.beginDelayedTransition(p0)
            }

        }

        return Item(v)
    }


    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        (p0 as Item).bindData(lists[p1], c)
    }

    class Item(itemView: View) : ViewHolder(itemView){
        fun bindData(_list : MenuItemObject, c: Context){
            //itemView.iv_headermenu.setImageURI(Uri.parse(_list.menuImg))
            itemView.tv_MenuTitle.text = _list.title
            itemView.rv_submenulist.layoutManager = LinearLayoutManager(c)
            itemView.rv_submenulist.hasFixedSize()
            itemView.rv_submenulist.adapter = SubMenuListAdapter(c, _list.subMenus)
        }
    }

}