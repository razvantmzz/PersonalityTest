package com.razvantmz.personalitytest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Answer(val id:Int, val value:String, val isSelected: Boolean = false): Parcelable