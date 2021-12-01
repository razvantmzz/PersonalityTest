package com.razvantmz.personalitytest.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.razvantmz.personalitytest.models.Question
import com.razvantmz.personalitytest.models.Quiz
import com.razvantmz.personalitytest.repository.QuizRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.CoroutineContext

class QuizData(private val quizId: Int) : KoinComponent, CoroutineScope {
    companion object {
        const val scopedName = "QuizData"
        const val scopedId = "scopeId"
    }
    override val coroutineContext: CoroutineContext by lazy {
        Job() + IO
    }

    private val quizRepository by inject<QuizRepository>()

    private val _quiz: MutableLiveData<Quiz> by lazy {
        MutableLiveData()
    }

    init {
        fetchQuiz()
    }

    val quiz: LiveData<Quiz> = _quiz

    fun getQuestionById(questionId: Int): Question? {
        return quiz.value?.questions?.firstOrNull { question -> question.id == questionId}
    }

    private fun fetchQuiz() {
        launch {
            quizRepository.getQuiz(quizId).let {
                _quiz.postValue(it)
            }
        }
    }

    fun selectAnswer(questionId: Int, answerId: Int): Question? {
        return getQuestionById(questionId)?.apply {
            answers.forEach { answer ->
                answer.isSelected = answer.id == answerId
            }
        }
    }
}