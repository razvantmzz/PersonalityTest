package com.razvantmz.personalitytest.ui.landing

import com.razvantmz.personalitytest.databinding.FragmentLandingBinding
import com.razvantmz.personalitytest.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LandingFragment : BaseFragment<FragmentLandingBinding>() {
    val viewModel: LandingViewModel by viewModel()

    override fun setBinding(): FragmentLandingBinding {
        return FragmentLandingBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
    }

    override fun setUpObservers() {
    }
}