package com.razvantmz.personalitytest.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.razvantmz.personalitytest.models.Quiz
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class QuizViewModel(private val quizId: Int) : ViewModel(), KoinComponent {
    private val quizData = getKoin().getOrCreateScope(QuizData.scopedId, named(QuizData.scopedName))
        .get<QuizData> { parametersOf(quizId) }

    val quiz: LiveData<Quiz> = quizData.quiz

    private val _currentQuestionIndex by lazy {
        MutableLiveData(0)
    }
    private val currentQuestionIndex: LiveData<Int> = _currentQuestionIndex

    val backBtnVisibility: LiveData<Boolean> = Transformations.map(quizData.selectedQuestion) {
        it?.let {
            (quiz.value?.questions?.indexOf(it) ?: -1) > 0
        } ?: false
    }

    val nextBtnVisibility: LiveData<Boolean> = Transformations.map(quizData.selectedQuestion) {
        it?.let { question ->
            question.answers.any { answer -> answer.isSelected } && currentQuestionIndex.value != quiz.value?.questions?.count() ?: 0 - 1
        } ?: false
    }

    override fun onCleared() {
        getKoin().getOrCreateScope(QuizData.scopedId, named(QuizData.scopedName)).close()
        super.onCleared()
    }
}