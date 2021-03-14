package com.example.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.CartItems
import com.example.shoppingapp.R

class ShoppingCarListItem (val itemList : ArrayList<CartItems>) : RecyclerView.Adapter<ShoppingCarListItem.ShoppingCarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCarListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_row,parent,false)
        return ShoppingCarListViewHolder(view)
        }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun onBindViewHolder(holder: ShoppingCarListViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }


    class ShoppingCarListViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        fun bindItems(item: CartItems) {
            val productName = itemView.findViewById(R.id.product_name) as TextView
            val productPrice  = itemView.findViewById(R.id.product_price) as TextView
            val offer  = itemView.findViewById(R.id.offer) as TextView
            val offerDescription  = itemView.findViewById(R.id.offer_description) as TextView
           // val totalCost  = itemView.findViewById(R.id.total_cost) as TextView

            productName.text = item.productName
            productPrice.text = item.priceTag

            if(item.isOfferAvailable) {
                offerDescription.visibility = View.VISIBLE
                offerDescription.text = item.offer
                offer.text = "Claim your offer!"
            } else {
                offerDescription.visibility = View.GONE
                offer.text = "Oops! Sorry no offer for this product"
                offer.setTextColor(Color.RED)
            }



        }
    }
}