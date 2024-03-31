package com.ifs21034.gmail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mail(
    var name: String,
    var icon: Int,
    var title: String,
    var message: String,
    var time: String,
) : Parcelable