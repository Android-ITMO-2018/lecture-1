package com.gitlab.faerytea.sampleapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log

import kotlinx.android.synthetic.main.activity_detail_view.*

class DetailViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)

        val user = intent?.getParcelableExtra<User>("USER")
        first_name_text.text = user?.name
        last_name_text.text = "is ${user?.age} years old"
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy: ")
    }

    companion object {
        const val LOG_TAG = "DetailViewActivity"
    }

}
