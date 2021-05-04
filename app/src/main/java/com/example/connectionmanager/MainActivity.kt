package com.example.connectionmanager

import android.content.Context
import android.hardware.SensorManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private  var connectivityManager: ConnectivityManager? = null


    private lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     connectivityManager =getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        btn1 =  findViewById(R.id.btn1)


        btn1.setOnClickListener {
            val activeNetwork: NetworkInfo? = connectivityManager!!.activeNetworkInfo
            val isconnected: Boolean = activeNetwork?.isConnectedOrConnecting==true
            if(isconnected)
                Toast.makeText(this, "You are connected to the Internet", Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(this, "You are not connected to the Internet", Toast.LENGTH_SHORT).show()

            }


        }

    }


}