package com.example.connectionmanager

import android.app.Service
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


  var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null


    private lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn1 = findViewById(R.id.btn1)


        btn1.setOnClickListener {

            connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE)

                    as ConnectivityManager
            if ( connectivity != null)
            {
                info = connectivity!!.activeNetworkInfo

                if (info != null)
                {
                    if (info!!.state == NetworkInfo.State.CONNECTED)
                    {
                        Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()
                    }
                }
                else
                {
                    Toast.makeText(context, "NOT CONNECTED", Toast.LENGTH_LONG).show()
                }
            }


        }

    }
}

