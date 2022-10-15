package com.example.myapplication

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting up resources
        val btnScan = findViewById<Button>(R.id.buttonScan)
        val arrow = findViewById<ImageView>(R.id.Arrow)
        arrow.setImageResource(R.mipmap.ic_launcher_foreground)
        //arrow.visibility = View.GONE
        arrow.visibility = View.VISIBLE
        var mp = MediaPlayer()
        mp.setDataSource(
            this,
            Uri.parse("android.resource://" + this.packageName + "/" + R.raw.scan)
        )

        btnScan.setOnClickListener {
            // Making buntton inactive while mp is in progress
            btnScan.isClickable = false
            // Starting media and setting arrow visibility
            mp.prepare()
            mp.start()
            arrow.visibility = View.VISIBLE
        }

        mp.setOnCompletionListener {
            btnScan.isClickable = true // Making button active
            arrow.visibility = View.GONE // Hiding arrow
            mp.stop()
        }
    }
}