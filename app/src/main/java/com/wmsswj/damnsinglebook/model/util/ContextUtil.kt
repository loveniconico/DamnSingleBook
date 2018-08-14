package com.wmsswj.damnsinglebook.model.util


import android.content.Context
import android.widget.Toast

class ContextUtil(private val context: Context) {

    private fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun toast(message:String) {
        context.toast(message)
    }
}