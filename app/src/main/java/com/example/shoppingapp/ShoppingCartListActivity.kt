package com.example.shoppingapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.ShoppingCarListItem
import com.example.adapter.ShoppingItemsAdapter
import com.example.data.Items

class ShoppingCartListActivity : AppCompatActivity(),
    ShoppingItemsListFragment.passItemsAddedToCartInterface {

    lateinit var shoppingItemsRecyclerView: RecyclerView

    var items = ArrayList<Items>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_shopping_itemslist)
        setSupportActionBar(findViewById(R.id.toolbar))


        //getting recyclerview from xml
        val recyclerView =  findViewById<RecyclerView>(R.id.rv_shopping_cartlist) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val adapter = ShoppingCarListItem(items)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

    }


    override fun passItem(ietm: ArrayList<Items>) {
      items = ietm
    }
}