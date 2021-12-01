package com.razvantmz.personalitytest.ui.quiz

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.razvantmz.personalitytest.databinding.FragmentQuestionBinding
import com.razvantmz.personalitytest.models.Answer
import com.razvantmz.personalitytest.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestionFragment : BaseFragment<FragmentQuestionBinding>() {
    private val viewModel: QuestionViewModel by viewModel()

    private val questionAdapter: QuestionAdapter by lazy {
        QuestionAdapter(emptyList(), listener)
    }

    private val listener by lazy {
        object : QuestionAdapterListener {
            override fun onAnswerSelected(item: Answer) {
            }
        }
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
    }
}