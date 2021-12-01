package com.razvantmz.personalitytest.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.razvantmz.personalitytest.models.Quiz
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class QuizViewModel(private val quizId:Int) : ViewModel(), KoinComponent {
    private val quizData = getKoin().getOrCreateScope(QuizData.scopedId, named(QuizData.scopedName))
        .get<QuizData> { parametersOf(quizId)}

    val quiz: LiveData<Quiz> = quizData.quiz
}