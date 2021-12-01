package com.razvantmz.personalitytest.ui.quiz

import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.razvantmz.personalitytest.databinding.FragmentQuizBinding
import com.razvantmz.personalitytest.models.Question
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
        binding?.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            quizViewPager.isUserInputEnabled = false
            nextBtn.setOnClickListener {
                if (quizViewPager.currentItem == (viewModel.quiz.value?.questions?.count()
                        ?: -1) - 1
                ) {
                    findNavController().navigate(
                        QuizFragmentDirections.actionQuizFragmentToQuizResultsFragment(
                            viewModel.quizId
                        )
                    )
                }
                quizViewPager.currentItem = quizViewPager.currentItem + 1
            }

            backBtn.setOnClickListener {
                quizViewPager.currentItem = quizViewPager.currentItem - 1
            }
        }
    }

    override fun setUpObservers() {
        viewModel.quiz.observe(viewLifecycleOwner) {
            val adapter = QuizViewPagerAdapter(requireActivity(), it.id, it.questions)
            binding?.apply {
                quizViewPager.adapter = adapter
                toolbar.title = it.title
            }
        }

        viewModel.backBtnVisibility.observe(viewLifecycleOwner) {
            binding?.backBtn?.isVisible = it
        }

        viewModel.nextBtnVisibility.observe(viewLifecycleOwner) {
            binding?.nextBtn?.isVisible = it
        }
    }
}

class QuizViewPagerAdapter(
    activity: FragmentActivity,
    val quizId: Int,
    var questionList: List<Question>
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return questionList.count()
    }

    override fun createFragment(position: Int): Fragment {
        return QuestionFragment.newInstance(quizId, questionList[position].id)
    }
}