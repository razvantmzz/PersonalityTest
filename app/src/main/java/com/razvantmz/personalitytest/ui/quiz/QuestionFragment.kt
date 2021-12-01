package com.razvantmz.personalitytest.ui.quiz

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.razvantmz.personalitytest.databinding.FragmentQuestionBinding
import com.razvantmz.personalitytest.models.Answer
import com.razvantmz.personalitytest.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class QuestionFragment : BaseFragment<FragmentQuestionBinding>() {
    private val viewModel: QuestionViewModel by viewModel {
        parametersOf(arguments?.getInt(QUIZ_ID), arguments?.getInt(QUESTION_ID))
    }

    companion object {
        private const val QUESTION_ID = "question_id"
        private const val QUIZ_ID = "quiz_id"

        fun newInstance(quizId: Int, questionId: Int): QuestionFragment {
            val bundle = Bundle()
            bundle.putInt(QUIZ_ID, quizId)
            bundle.putInt(QUESTION_ID, questionId)
            return QuestionFragment().apply {
                this.arguments = bundle
            }
        }
    }

    private val questionAdapter: QuestionAdapter by lazy {
        QuestionAdapter(emptyList(), listener)
    }

    private val listener by lazy {
        object : QuestionAdapterListener {
            override fun onAnswerSelected(item: Answer) {
                viewModel.selectAnswer(item.id)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.setSelectedQuestion()
    }

    override fun setBinding(): FragmentQuestionBinding {
        return FragmentQuestionBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding?.questionsRv?.apply {
            this.layoutManager = layoutManager
            adapter = questionAdapter
        }
    }

    override fun setUpObservers() {
        viewModel.question.observe(viewLifecycleOwner) { question ->
            question?.let {
                binding?.questionTitle?.text = question.title
                questionAdapter.updateItems(it.answers)
            }
        }
    }
}