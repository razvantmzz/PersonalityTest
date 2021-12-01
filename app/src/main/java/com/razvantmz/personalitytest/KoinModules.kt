package com.razvantmz.personalitytest

import com.razvantmz.personalitytest.ui.splashscreen.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    viewModel { SplashViewModel() }
}