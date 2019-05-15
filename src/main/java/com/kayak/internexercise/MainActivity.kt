package com.kayak.internexercise


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kayak.internexercise.Airlinedata.NameAdapter
import com.kayak.internexercise.Airlinemodel.Airlinenames
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter:NameAdapter?=null
    private var airlinelist:ArrayList<Airlinenames>?=null
    private var layoutManager:RecyclerView.LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        airlinelist= ArrayList<Airlinenames>()
        layoutManager=LinearLayoutManager(this)
        adapter= NameAdapter(airlinelist!!,this)

        myRecyclerView.layoutManager=layoutManager
        myRecyclerView.adapter=adapter
        val air = AirlineInfos.unsortedAirlines
        var airline_namelist = arrayOfNulls<String>(air.size) //array that contains the names of the airlines
        var airline_logolist = arrayOfNulls<Int>(air.size) //array that contains the logos of the airlines
        var airline_urllist = arrayOfNulls<String>(air.size) //array that contains the url of the airlines
        for (i in 0..air.size-1) {
            airline_namelist[i]=air[i].name
            airline_logolist[i]=air[i].logoId
            airline_urllist[i]=air[i].site
        }
        //Sorts the airlines in lexicographical order.
        for (i in 0..airline_namelist.size-1) {
            for (j in i + 1..airline_namelist.size-1) {
                if (airline_namelist[j]?.let { airline_namelist[i]!!.compareTo(it) }!! > 0) {
                    var temp = airline_namelist[i]
                    airline_namelist[i] = airline_namelist[j]
                    airline_namelist[j] = temp
                    temp = airline_urllist[i]
                    airline_urllist[i] = airline_urllist[j]
                    airline_urllist[j] = temp
                    var temp1 = airline_logolist[i]
                    airline_logolist[i] = airline_logolist[j]
                    airline_logolist[j] = temp1
                }
            }
        }
        //Store the starting letter for the airlines that must be displayed in the header row
        var myset = mutableSetOf<String>()
        for(i in 0..airline_namelist.size-1) {
            myset.add(airline_namelist[i]!!.get(0).toString())
        }
        var airline_name_letter = arrayOfNulls<String>(myset.size) //array that contains the letter for each header row
        for(i in 0..airline_name_letter.size-1) {
            airline_name_letter[i] = myset.elementAt(i)
        }
        var new_arr = arrayOfNulls<String>(airline_namelist.size + airline_name_letter.size) //new array which contains both the airline name and header name
        for(i in 0..airline_namelist.size-1) {
            new_arr[i] = airline_namelist[i]
        }
        var l = 0
        for(i in airline_namelist.size..new_arr.size-1) {
            new_arr[i] = airline_name_letter[l]
            l = l + 1
        }
        //sorts in alphabetical order.
        for (i in 0..new_arr.size-1) {
            for (j in i + 1..new_arr.size-1) {
                if (new_arr[j]?.let { new_arr[i]!!.compareTo(it) }!! > 0) {
                    var temp = new_arr[i]
                    new_arr[i] = new_arr[j]
                    new_arr[j] = temp
                }
            }
        }
        var count = 0
        //Adds the details of the airlines to the model which is used to display in the recycle view.
        for(i in 0..new_arr.size-1) {
            var ss = new_arr[i]
            if (ss != null) {
                //header data
                if(ss.length == 1) {
                    count = count + 1
                    var nn = Airlinenames()
                    nn.airlineurl=null
                    nn.airlinelogo=0
                    nn.airlinenames= new_arr[i]
                    nn.type=2
                    airlinelist?.add(nn)
                }
                //Airline data
                else {
                    var nn = Airlinenames()
                    nn.airlinenames=new_arr[i]
                    nn.airlinelogo=airline_logolist[i - count]
                    nn.airlineurl=airline_urllist[i - count]
                    nn.type=1
                    airlinelist?.add(nn)
                }
            }

        }
        //notifies the adapter that the data has changed.
        adapter!!.notifyDataSetChanged()

    }
}
