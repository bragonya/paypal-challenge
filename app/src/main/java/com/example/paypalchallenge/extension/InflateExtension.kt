package com.example.paypalchallenge.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
/**
 * Extension in order to reduce boilerplate code
 * inflating views
 *
 * @param id of the view to be inflated
 * @param container is the parent view of the inflated one
 * @param attachToRoot returns the parent view instead of the inflated one
 *
 * @return the inflated view or the parent view
 *
 * @author Brayan Yaquián
 *
 * */
fun Context.inflate(
    @LayoutRes id: Int,
    container: ViewGroup?,
    attachToRoot: Boolean = container != null
): View {
    return LayoutInflater.from(this).inflate(id, container, attachToRoot)
}