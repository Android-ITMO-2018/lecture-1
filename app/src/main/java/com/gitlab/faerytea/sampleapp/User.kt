package com.gitlab.faerytea.sampleapp

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(val age: Int, val name: String) : Parcelable

fun createUsers(count: Int): List<User> {
    val res = mutableListOf<User>()
    val rand = Random()
    repeat(count) {
        res.add(
            when (rand.nextInt(4)) {
                0 -> User(30, "Jonathan Joestar")
                1 -> User(20, "Jotaro Kudjo")
                2 -> User(100, "Dio Brando")
                else -> User(0, "no name")
            }
        )
    }
    return res
}

fun Context.createUserIntent(user: User): Intent {
    val intent = Intent(this, DetailViewActivity::class.java)
    intent.putExtra("USER", user)
    return intent
}
