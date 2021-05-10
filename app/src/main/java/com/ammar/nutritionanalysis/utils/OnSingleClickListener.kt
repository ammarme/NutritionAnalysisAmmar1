package com.ammar.nutritionanalysis.utils

import android.view.View

class OnSingleClickListener(val listener: (View) -> Unit) : View.OnClickListener {

    private val interval = 1000
    private var lastClick = 0L
    override fun onClick(v: View) {
        val current = System.currentTimeMillis()
        val elapsed = current - lastClick
        if (elapsed >= interval) {
            listener(v)
            lastClick = current
        }
    }
}

fun View.setOnSingleClickListener(listener:(View) -> Unit){
    this.setOnClickListener(OnSingleClickListener(listener))
}