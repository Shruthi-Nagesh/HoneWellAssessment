package com.example.adapter

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.data.CartItems
import com.example.data.Items
import com.example.shoppingapp.R

class ShoppingItemsAdapter(val itemList : ArrayList<Items>, private val onAddToCartListerner:onAddToCarClick) : RecyclerView.Adapter<ShoppingItemsAdapter.ShoppingItemsViewHolder>(){

    lateinit var mOnAddToCartListerner : onAddToCarClick

    val items = ArrayList<CartItems>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_itemslist_recycleview_row,parent,false)
        mOnAddToCartListerner = onAddToCartListerner

        return ShoppingItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
      return itemList.size;
    }

    interface onAddToCarClick {
        fun passData(data: ArrayList<CartItems>)
    }

    class ShoppingItemsViewHolder(itemsView: View): RecyclerView.ViewHolder(itemsView) {

        fun bindItems(item: Items) {
            val productName = itemView.findViewById(R.id.product_name) as TextView
            val productPrice  = itemView.findViewById(R.id.product_price) as TextView
            val offer  = itemView.findViewById(R.id.offer) as TextView
            val offerDescription  = itemView.findViewById(R.id.offer_description) as TextView
            val reviewText  = itemView.findViewById(R.id.review_text) as TextView
            val reviewSection  = itemView.findViewById(R.id.review_section) as LinearLayout
            val reviewEditText = itemView.findViewById(R.id.ed_review) as EditText
            val addToCart  = itemView.findViewById(R.id.addtocard) as TextView
            val btnSubmit  = itemView.findViewById(R.id.btn_submit) as Button
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


//            addToCart.setOnClickListener(View.OnClickListener {
//                val items = ArrayList<Items>()
//                //adding some dummy data to the list
//                items.add(Items(productName.text.toString(), productPrice.text.toString(),item.isOfferAvailable,""))
//
//
//            })


                reviewText.setOnClickListener(View.OnClickListener {
                    reviewSection.visibility = View.VISIBLE
                })

            reviewEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if(s.toString().length > 0) {
                        btnSubmit.isEnabled = true
                    } else {
                        btnSubmit.isEnabled = false
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    //Do Nothing
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(s.toString().length > 0) {
                        btnSubmit.isEnabled = true
                    } else {
                        btnSubmit.isEnabled = false
                    }
                }
            })

            btnSubmit.setOnClickListener(View.OnClickListener {
                if(reviewEditText.text.toString().length > 0) {
                    btnSubmit.isEnabled = true
                    reviewSection.visibility = View.GONE
                    reviewText.text = reviewEditText.text.toString()
                } else {
                    btnSubmit.isEnabled = false
                    Toast.makeText(itemView.context,"Please write donw your review comments to make the submit button enabled", Toast.LENGTH_LONG).show()
            }

        })
    }
    }
        override fun onBindViewHolder(holder: ShoppingItemsViewHolder, position: Int) {

            holder.bindItems(itemList[position])

            holder.itemView.findViewById<TextView>(R.id.addtocard).setOnClickListener(View.OnClickListener {
                //adding some dummy data to the list
                holder.itemView.findViewById<TextView>(R.id.addtocard).text = " Added to Cart"
                items.add(CartItems(itemList[position].productName, itemList[position].priceTag,itemList[position].isOfferAvailable,itemList[position].offer))
            })
            mOnAddToCartListerner.passData(items)
    }



}