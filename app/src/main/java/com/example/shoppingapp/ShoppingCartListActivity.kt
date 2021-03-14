package com.example.shoppingapp

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.ShoppingCarListItem
import com.example.data.CartItems

class ShoppingCartListActivity : AppCompatActivity() {
    var items = ArrayList<CartItems>()

     var totalPrice : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_shopping_itemslist)
        setSupportActionBar(findViewById(R.id.toolbar))

        val totalCost  = findViewById(R.id.total_cost) as TextView
        val noProductTextView  = findViewById(R.id.no_product_added_cart) as TextView
        val cartItemsLayout  = findViewById(R.id.cart_items) as LinearLayout
        val recyclerView =  findViewById<RecyclerView>(R.id.rv_shopping_cartlist) as RecyclerView


        items =  intent?.getParcelableArrayListExtra<Parcelable>("QuestionListExtra") as ArrayList<CartItems>

        if(items.size > 0) {
            noProductTextView.visibility = View.GONE
            cartItemsLayout.visibility = View.VISIBLE
        }

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val adapter = ShoppingCarListItem(items)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        items.forEach {
            totalPrice = it.priceTag.toString().toInt() + totalPrice
        }
        totalCost.text = "$totalPrice"
        Log.e("TotalPrice",totalPrice.toString())

    }

}