package com.razvantmz.personalitytest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Question(val id:Int, val title: String, val answers:List<Answer>): Parcelable {
}