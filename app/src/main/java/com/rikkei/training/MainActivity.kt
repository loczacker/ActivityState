package com.rikkei.training

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private var currentPosition: Int = 0

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

    }


    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.tonight)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mediaPlayer.pause()
        currentPosition = mediaPlayer.currentPosition
        mediaPlayer.release()
        outState.putInt("currentPosition", currentPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentPosition = savedInstanceState.getInt("currentPosition")
        mediaPlayer.seekTo(currentPosition)
        mediaPlayer.start()
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}