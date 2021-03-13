package com.example.shoppingapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.ShoppingItemsAdapter
import com.example.data.Items

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ShoppingItemsListFragment : Fragment(), ShoppingItemsAdapter.onAddToCarClick {



    lateinit var items : ArrayList<Items>
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_shoppinglist_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getting recyclerview from xml
        val recyclerView =  view.findViewById<RecyclerView>(R.id.rv_shopping_items_list) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)


        //crating an arraylist to store users using the data class user
        val items = ArrayList<Items>()

        //adding some dummy data to the list
        items.add(Items("Nescafe", "288.00",true,"Get an awesome coffee mug!!!"))
        items.add(Items("Red LAbel", "249", false, ""))
        items.add(Items("Pure Almonds", "480", false, ""))
        items.add(Items("Cashew", "520", true, "Get a pista worth of Rs.70"))
        items.add(Items("Sugar", "50", false, ""))
        items.add(Items("Milk", "35", false, ""))


        //creating our adapter
        val adapter = ShoppingItemsAdapter(items, null)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        view.findViewById<ImageView>(R.id.cartImage).setOnClickListener {
            val intent = Intent(context, ShoppingCartListActivity::class.java)
            startActivity(intent)

        }

    }

    interface passItemsAddedToCartInterface {
        fun passItem(ietm: ArrayList<Items>)
    }

    override fun passData(data: ArrayList<Items>) {
        items = data
    }
}