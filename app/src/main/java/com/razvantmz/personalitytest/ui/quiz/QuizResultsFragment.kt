package com.razvantmz.personalitytest.ui.quiz

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.razvantmz.personalitytest.Personality
import com.razvantmz.personalitytest.R
import com.razvantmz.personalitytest.databinding.FragmentQuizResultsBinding
import com.razvantmz.personalitytest.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class QuizResultsFragment : BaseFragment<FragmentQuizResultsBinding>() {
    private val args: QuizResultsFragmentArgs by navArgs()
    private val viewModel: QuizResultsViewModel by viewModel {
        parametersOf(args.quizId)
    }

    override fun setBinding(): FragmentQuizResultsBinding {
        return FragmentQuizResultsBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
        binding?.btnContinue?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun setUpObservers() {
        viewModel.testResult.observe(viewLifecycleOwner) { personality ->
            personality?.let {
                binding?.apply {
                    result.text = getString(
                        when (personality) {
                            Personality.Introverted -> R.string.fragment_quiz_results_introverted
                            Personality.Extroverted -> R.string.fragment_quiz_results_extroverted
                            Personality.IntrovertedExtrovert -> R.string.fragment_quiz_results_introverted_extrovert
                        }
                    )
                    statistics.text = getString(
                        when (personality) {
                            Personality.Introverted -> R.string.fragment_quiz_results_introverted_statistic
                            Personality.Extroverted -> R.string.fragment_quiz_results_extroverted_statistic
                            Personality.IntrovertedExtrovert -> R.string.fragment_quiz_results_introverted_extrovert_statistic
                        }
                    )
                }
            }
        }
    }
}