package com.wipro.testapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import com.wipro.testapp.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onResume() {
        super.onResume()

        val intent = Intent(this, FactsActivity::class.java)
        Handler().postDelayed(Runnable {
            startActivity(Intent(intent))
            finish()
        }, 1500)
    }
}


