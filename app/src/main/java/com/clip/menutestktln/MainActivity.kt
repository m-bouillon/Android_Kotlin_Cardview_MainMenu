package com.clip.menutestktln

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.setTitleTextColor(Color.DKGRAY)

        menuList.layoutManager = LinearLayoutManager(this)
        menuList.hasFixedSize()
        menuList.adapter = MenuListAdapter(this, getLists())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        title = "Welcome User"
        menuInflater.inflate(R.menu.menu_tool_bar, menu)
        return true
    }

    fun getLists() : ArrayList<MenuItemObject>{
        //Give items to menu // (this part is just data test)

        val menus = ArrayList<MenuItemObject>()

        val sub_menu1 = ArrayList<String>()
        sub_menu1.add("Sub Menu 1")

        val sub_menu2 = ArrayList<String>()
        sub_menu2.add("Sub Menu 1")
        sub_menu2.add("Sub Menu 2")

        val sub_menu3 = ArrayList<String>()
        sub_menu3.add("Sub Menu 1")
        sub_menu3.add("Sub Menu 2")
        sub_menu3.add("Sub Menu 3")

        val sub_menu4 = ArrayList<String>()
        sub_menu4.add("Sub Menu 1")
        sub_menu4.add("Sub Menu 2")
        sub_menu4.add("Sub Menu 3")
        sub_menu4.add("Sub Menu 4")

        menus.add(MenuItemObject("Menu 1", sub_menu1, "" ))
        menus.add(MenuItemObject("Menu 2", sub_menu2, "" ))
        menus.add(MenuItemObject("Menu 3",sub_menu3,""))
        menus.add(MenuItemObject("Menu 4", sub_menu4, ""))

        return menus

    }


}
