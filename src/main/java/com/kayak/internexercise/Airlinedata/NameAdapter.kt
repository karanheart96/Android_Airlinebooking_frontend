package com.kayak.internexercise.Airlinedata

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kayak.internexercise.R
import com.kayak.internexercise.Airlinemodel.Airlinenames
import android.net.Uri

/*
The Adapter which is used to bind the airlines data to the recycle view.
 */
class NameAdapter(private val list: ArrayList<Airlinenames>,private val context: Context) :RecyclerView.Adapter<NameAdapter.ViewHolder>()
{
    /*
    Displays the name of the airlines
    Displays the logo of the airlines
    Listens to an event and directs to the webpage of the particular airline.
    Displays the header name.
     */
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        /*
        This function is used for displaying the relevant data.
        1->Displays the Airline name,Airline Logo and creates an onClickListener to open the website in an external browser.
        2->Displays the Header name.
         */
        fun bindItem(names:Airlinenames) {
            if(names.type == 1) {
            var name:TextView=itemView.findViewById(R.id.airline_ID) as TextView
            name.text=names.airlinenames
            var logo:ImageView=itemView.findViewById(R.id.iamge_ID) as ImageView
            logo.setImageResource(names.airlinelogo!!)
            itemView.setOnClickListener {
                var url = names.airlineurl
                url = "http://" + url
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(itemView.context, i, null)
            }
            }
            else if(names.type == 2) {
                var name1:TextView=itemView.findViewById(R.id.textView2) as TextView
                name1.text=names.airlinenames
            }
        }

    }

    /*
    Inflates the card layout inside the recycle view.
    1->Inflates the data to the Airline Card.
    2->Inflates the data to the Header Card.
     */
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NameAdapter.ViewHolder {
        when(p1) {
            1-> {
                val view = LayoutInflater.from(context).inflate(R.layout.card_layout,p0,false)
                return ViewHolder(view)

            }

            2-> {
                val view = LayoutInflater.from(context).inflate(R.layout.card_layout_two,p0,false)
                return ViewHolder(view)
            }
        }
            return null!!
    }

    /*
    Returns the size of the list which contains the airlines data.
     */
    override fun getItemCount(): Int {
        return list.size
    }

    /*
    Binds the data to the recycler view.
     */
    override fun onBindViewHolder(p0: NameAdapter.ViewHolder, p1: Int) {
        p0.bindItem(list[p1])
    }

    /*
    Returns the type of the card
    1->Airline data card
    2->Header data card.
     */
    override fun getItemViewType(position: Int): Int {
        var type:Int = 0
        when(list[position].type) {
            1-> type = 1
            2-> type = 2
        }
        return type
    }
}