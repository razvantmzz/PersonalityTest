package com.razvantmz.personalitytest.ui.quiz

import androidx.navigation.fragment.navArgs
import com.razvantmz.personalitytest.databinding.FragmentQuizBinding
import com.razvantmz.personalitytest.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class QuizFragment : BaseFragment<FragmentQuizBinding>() {
    private val args: QuizFragmentArgs by navArgs()

    private val viewModel by viewModel<QuizViewModel> { parametersOf(args.quizId) }
    override fun setBinding(): FragmentQuizBinding {
        return FragmentQuizBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
    }

    override fun setUpObservers() {
    }
}