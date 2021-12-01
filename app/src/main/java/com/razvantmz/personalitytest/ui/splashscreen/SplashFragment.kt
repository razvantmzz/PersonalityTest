package com.razvantmz.personalitytest.ui.splashscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.razvantmz.personalitytest.R
import com.razvantmz.personalitytest.databinding.SplashFragmentBinding
import com.razvantmz.personalitytest.ui.base.BaseFragment

class SplashFragment : BaseFragment<SplashFragmentBinding>() {
    override fun setBinding(): SplashFragmentBinding {
        return SplashFragmentBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
    }

    override fun setUpObservers() {
    }
}