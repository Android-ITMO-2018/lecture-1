package com.gitlab.faerytea.sampleapp


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import android.widget.TextView

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var inc: TextView
    private lateinit var dec: TextView

    private var cnt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = findViewById<TextView>(R.id.result)

        name = findViewById(R.id.name)
        age = findViewById(R.id.age)

        inc = findViewById(R.id.inc)
        dec = findViewById(R.id.dec)

        result.setOnClickListener {
            inc.text = name.text
            dec.text = age.text
        }

        inc.setOnClickListener { result.text = (++cnt).toString() }
        dec.setOnClickListener { result.text = (--cnt).toString() }


        if (savedInstanceState != null) {
            cnt = savedInstanceState.getInt(CNT)
            result.text = cnt.toString()
            val user = savedInstanceState.getParcelable<User>(USER)
            if (user != null) {
                inc.text = user.name
                dec.text = user.age.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(CNT, cnt)
        try {
            outState.putParcelable(USER, User(age.text.toString().toInt(), name.text.toString()))
        } catch (ignored: NumberFormatException) {
            // ignore
        }

        super.onSaveInstanceState(outState)
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
        private const val LOG_TAG = "MainActivity"
        private val CNT = MainActivity::class.java.name + ".cnt"
        private val USER = MainActivity::class.java.name + ".usr"
    }
}
