package com.razvantmz.personalitytest

import com.razvantmz.personalitytest.repository.QuizRepository
import com.razvantmz.personalitytest.repository.QuizRepositoryImpl
import com.razvantmz.personalitytest.ui.landing.LandingViewModel
import com.razvantmz.personalitytest.ui.quiz.QuestionViewModel
import com.razvantmz.personalitytest.ui.quiz.QuizData
import com.razvantmz.personalitytest.ui.quiz.QuizResultsViewModel
import com.razvantmz.personalitytest.ui.quiz.QuizViewModel
import com.razvantmz.personalitytest.ui.splashscreen.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val modules = module {
    single<QuizRepository> { QuizRepositoryImpl() }

    viewModel { SplashViewModel() }
    viewModel { (quizId:Int, questionId:Int) -> QuestionViewModel(quizId, questionId) }
    viewModel { LandingViewModel() }
    viewModel { (quizId:Int) -> QuizViewModel(quizId) }
    viewModel { (quizId:Int) -> QuizResultsViewModel(quizId) }

    scope(named(QuizData.scopedName)) {
        scoped { (quizId: Int) -> QuizData(quizId) }
    }
}