package com.razvantmz.personalitytest.ui.splashscreen

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.razvantmz.personalitytest.databinding.SplashFragmentBinding
import com.razvantmz.personalitytest.ui.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<SplashFragmentBinding>() {
    override fun setBinding(): SplashFragmentBinding {
        return SplashFragmentBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
        navigateToLandingScreen()
    }

    override fun setUpObservers() {
    }

    private fun navigateToLandingScreen() {
        lifecycleScope.launch {
            delay(1500)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLandingFragment())
        }
    }
}