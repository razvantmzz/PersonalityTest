package com.razvantmz.personalitytest.repository

import com.razvantmz.personalitytest.models.Answer
import com.razvantmz.personalitytest.models.Question
import com.razvantmz.personalitytest.models.Quiz

interface QuizRepository {
    suspend fun getQuiz(id: Int): Quiz
}

class QuizRepositoryImpl : QuizRepository {
    override suspend fun getQuiz(id: Int): Quiz {
        return Quiz(id, getQuestions())
    }

    private fun getQuestions(): List<Question> {
        val question1 = Question(
            id = 1,
            title = "You’re really busy at work and a colleague is telling you their life story and personal woes. You:",
            answers = listOf(
                Answer(
                    id = 1,
                    value = "Don’t dare to interrupt them"
                ),
                Answer(
                    id = 2,
                    value = "Think it’s more important to give them some of your time; work can wait "
                ),
                Answer(
                    id = 3,
                    value = "Listen, but with only with half an ear "
                ),
                Answer(
                    id = 4,
                    value = "Interrupt and explain that you are really busy at the moment "
                )
            )
        )

        val question2 = Question(
            id = 2,
            title = "You’ve been sitting in the doctor’s waiting room for more than 25 minutes. You:",
            answers = listOf(
                Answer(
                    id = 1,
                    value = "Look at your watch every two minutes"
                ),
                Answer(
                    id = 2,
                    value = "Bubble with inner anger, but keep quiet"
                ),
                Answer(
                    id = 3,
                    value = "Explain to other equally impatient people in the room that the doctor is always running late"
                ),
                Answer(
                    id = 4,
                    value = "Complain in a loud voice, while tapping your foot impatiently"
                )
            )
        )

        val question3 = Question(
            id = 3,
            title = "You’re having an animated discussion with a colleague regarding a project that you’re in charge of. You:",
            answers = listOf(
                Answer(
                    id = 1,
                    value = "Don’t dare contradict them"
                ),
                Answer(
                    id = 2,
                    value = "Think that they are obviously right"
                ),
                Answer(
                    id = 3,
                    value = "Defend your own point of view, tooth and nail"
                ),
                Answer(
                    id = 4,
                    value = "Continuously interrupt your colleague"
                )
            )
        )

        return listOf(
            question1,
            question2,
        )
    }
}