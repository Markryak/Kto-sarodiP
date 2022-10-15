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

        var scan = findViewById<Button>(R.id.buttonScan)
        var stop = findViewById<Button>(R.id.buttonStop)
        var mp = MediaPlayer()
        var arrow = findViewById<ImageView>(R.id.Arrow)
        arrow.visibility = View.GONE
        scan.setOnClickListener {
            mp.setDataSource(
                this,
                Uri.parse("android.resource://" + this.packageName + "/" + R.raw.scan)
            )
            arrow.visibility = View.VISIBLE
            arrow.setImageResource(R.mipmap.ic_launcher_foreground)
            mp.prepare()
            mp.start()
            if (mp.isPlaying()) {
                scan.isClickable = false
            }
            stop.setOnClickListener {
                arrow.visibility = View.GONE
                arrow.setImageResource(R.mipmap.ic_launcher_foreground)
                mp.stop()
                mp.release()
                mp = MediaPlayer()
                if (!mp.isPlaying()) {
                    scan.isClickable = true
                }
            }
        }
    }
}