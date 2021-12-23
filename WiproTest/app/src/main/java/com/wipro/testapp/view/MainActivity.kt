package com.wipro.testapp.view

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.core.os.postDelayed
import com.bumptech.glide.load.engine.Resource
import com.wipro.testapp.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // Splash Activity with the dealy of 1500ms
    override fun onResume() {
        super.onResume()

        val intent = Intent(this, FactsActivity::class.java)
        Handler().postDelayed(Runnable {
            startActivity(Intent(intent))
            finish()
        }, 1500)
    }
}


