package com.razvantmz.personalitytest.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.razvantmz.personalitytest.enums.Personality
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.getKoin

class QuizResultsViewModel(val quizId: Int) : ViewModel() {
    private val quizData = getKoin().getOrCreateScope(QuizData.scopedId, named(QuizData.scopedName))
        .get<QuizData> { parametersOf(quizId) }

    private val _testResult: MutableLiveData<Personality> by lazy {
        MutableLiveData(quizData.getQuizResult())
    }
    val testResult: LiveData<Personality> = _testResult

    override fun onCleared() {
        getKoin().getOrCreateScope(QuizData.scopedId, named(QuizData.scopedName)).close()
        super.onCleared()
    }
}