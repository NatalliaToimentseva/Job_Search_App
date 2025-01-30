package com.effectivemobile.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.openLink(link: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(link)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    this.startActivity(intent)
}