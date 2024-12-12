package com.example.faded_slider

import android.content.Context
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class SlowSnapHelper(private val context: Context, private val millisPerInch: Float) : PagerSnapHelper() {

    override fun createScroller(layoutManager: RecyclerView.LayoutManager?): RecyclerView.SmoothScroller{
        return object : LinearSmoothScroller(context) {
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                return millisPerInch / displayMetrics.densityDpi
            }
        }
    }

}