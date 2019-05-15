package com.kayak.internexercise

import java.util.ArrayList

/**
 * This class contains the static factory method that you should call in order
 * to obtain the list of airlines to work with in MainActivity.kt
 *
 * Do not modify the contents of this class
 */
object AirlineInfos {

    val unsortedAirlines: List<AirlineInfo>
        get() {
            val airlines = ArrayList<AirlineInfo>()

            airlines.add(AirlineInfo(R.drawable.logo_ua, "United", "www.united.com/"))
            airlines.add(AirlineInfo(R.drawable.logo_dl, "Delta", "www.delta.com"))
            airlines.add(AirlineInfo(R.drawable.logo_aa, "American Airlines", "www.aa.com/homePage.do?locale=en_US"))
            airlines.add(AirlineInfo(R.drawable.logo_us, "US Airways", "www.usairways.com"))
            airlines.add(AirlineInfo(R.drawable.logo_lh, "Lufthansa", "www.lufthansa.com/us/en/homepage"))
            airlines.add(AirlineInfo(R.drawable.logo_ba, "British Airways", "www.britishairways.com/travel/home/public/en_us"))
            airlines.add(AirlineInfo(R.drawable.logo_kl, "KLM Royal Dutch", "www.klm.com"))
            airlines.add(AirlineInfo(R.drawable.logo_af, "Air France", "www.airfrance.us"))
            airlines.add(AirlineInfo(R.drawable.logo_as, "Alaska Airlines", "www.alaskaair.com"))
            airlines.add(AirlineInfo(R.drawable.logo_az, "Alitalia", "www.alitalia.com/US_EN/home/index.aspx"))
            airlines.add(AirlineInfo(R.drawable.logo_lx, "SWISS", "www.swiss.com/web/EN/Pages/index.aspx?1281465960810&Country=US"))
            airlines.add(AirlineInfo(R.drawable.logo_ac, "Air Canada", "www.aircanada.com/en/us/home.html"))
            airlines.add(AirlineInfo(R.drawable.logo_os, "Austrian Airlines", "www.austrian.com?cc=US&sc_lang=en"))
            airlines.add(AirlineInfo(R.drawable.logo_ib, "Iberia", "www.iberia.com"))
            airlines.add(AirlineInfo(R.drawable.logo_tk, "Turkish Airlines", "www.thy.com/en-US/index.aspx"))
            airlines.add(AirlineInfo(R.drawable.logo_b6, "JetBlue Airways", "www.jetblue.com"))
            airlines.add(AirlineInfo(R.drawable.logo_sn, "Brussels Airlines", "www.brusselsairlines.com/en_us/"))
            airlines.add(AirlineInfo(R.drawable.logo_tp, "TAP Portugal", "www.flytap.com/USA/en/"))
            airlines.add(AirlineInfo(R.drawable.logo_ab, "Air Berlin", "www.airberlin.com"))
            airlines.add(AirlineInfo(R.drawable.logo_fl, "AirTran", "www.airtran.com"))
            airlines.add(AirlineInfo(R.drawable.logo_nh, "ANA", "www.ana.co.jp"))
            airlines.add(AirlineInfo(R.drawable.logo_sk, "SAS", "http://www.flysas.com/en/us/"))
            airlines.add(AirlineInfo(R.drawable.logo_ek, "Emirates", "www.emirates.com/usa/index.asp"))
            airlines.add(AirlineInfo(R.drawable.logo_f9, "Frontier", "www.flyfrontier.com"))
            airlines.add(AirlineInfo(R.drawable.logo_ey, "Etihad Airways", "www.etihadairways.com"))
            return airlines
        }
}// static methods only
