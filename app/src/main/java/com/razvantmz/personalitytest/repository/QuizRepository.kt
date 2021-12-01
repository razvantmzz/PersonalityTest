package com.razvantmz.personalitytest.repository

import com.razvantmz.personalitytest.models.Answer
import com.razvantmz.personalitytest.models.Question
import com.razvantmz.personalitytest.models.Quiz

interface QuizRepository {
    suspend fun getQuiz(id: Int): Quiz
}

class QuizRepositoryImpl : QuizRepository {
    override suspend fun getQuiz(id: Int): Quiz {
        return Quiz(id, "Introvert or extrovert", getQuestions())
    }

    private fun getQuestions(): List<Question> {
        val question1 = Question(
            id = 1,
            title = "You’re really busy at work and a colleague is telling you their life story and personal woes. You:",
            answers = listOf(
                Answer(
                    id = 1,
                    value = "Don’t dare to interrupt them",
                    personalityTrait = 2
                ),
                Answer(
                    id = 2,
                    value = "Think it’s more important to give them some of your time; work can wait",
                    personalityTrait = 1
                ),
                Answer(
                    id = 3,
                    value = "Listen, but with only with half an ear",
                    personalityTrait = -1
                ),
                Answer(
                    id = 4,
                    value = "Interrupt and explain that you are really busy at the moment",
                    personalityTrait = -2
                )
            )
        )

        val question2 = Question(
            id = 2,
            title = "You’ve been sitting in the doctor’s waiting room for more than 25 minutes. You:",
            answers = listOf(
                Answer(
                    id = 5,
                    value = "Look at your watch every two minutes",
                    personalityTrait = 2
                ),
                Answer(
                    id = 2,
                    value = "Bubble with inner anger, but keep quiet",
                    personalityTrait = 1
                ),
                Answer(
                    id = 7,
                    value = "Explain to other equally impatient people in the room that the doctor is always running late",
                    personalityTrait = -1
                ),
                Answer(
                    id = 8,
                    value = "Complain in a loud voice, while tapping your foot impatiently",
                    personalityTrait = 2
                )
            )
        )

        val question3 = Question(
            id = 3,
            title = "You’re having an animated discussion with a colleague regarding a project that you’re in charge of. You:",
            answers = listOf(
                Answer(
                    id = 9,
                    value = "Don’t dare contradict them",
                    personalityTrait = 2
                ),
                Answer(
                    id = 10,
                    value = "Think that they are obviously right",
                    personalityTrait = 1
                ),
                Answer(
                    id = 11,
                    value = "Defend your own point of view, tooth and nail",
                    personalityTrait = -1
                ),
                Answer(
                    id = 12,
                    value = "Continuously interrupt your colleague",
                    personalityTrait = -2
                )
            )
        )

        val question4 = Question(
            id = 4,
            title = "You are taking part in a guided tour of a museum. You:",
            answers = listOf(
                Answer(
                    id = 13,
                    value = "Are a bit too far towards the back so don’t really hear what the guide is saying",
                    personalityTrait = 2
                ),
                Answer(
                    id = 14,
                    value = "Follow the group without question",
                    personalityTrait = 1
                ),
                Answer(
                    id = 15,
                    value = " Make sure that everyone is able to hear properly",
                    personalityTrait = -1
                ),
                Answer(
                    id = 16,
                    value = "Are right up the front, adding your own comments in a loud voice",
                    personalityTrait = -2
                )
            )
        )

        return listOf(
            question1,
            question2,
            question3,
            question4,
        )
    }
}