package com.razvantmz.personalitytest.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.razvantmz.personalitytest.models.Question
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.getKoin

class QuestionViewModel(private val quizId: Int, private val questionId: Int) : ViewModel() {
    private val quizData = getKoin().getOrCreateScope(QuizData.scopedId, named(QuizData.scopedName))
        .get<QuizData> { parametersOf(quizId) }

    private val _question: MutableLiveData<Question> by lazy {
        MutableLiveData<Question>(quizData.getQuestionById(questionId))
    }
    val question: LiveData<Question> = _question

    fun selectAnswer(id: Int) {
        _question.value = quizData.selectAnswer(questionId, id)
        quizData.selectQuestion(question.value)
    }

    fun setSelectedQuestion() {
        quizData.selectQuestion(question.value)
    }
}