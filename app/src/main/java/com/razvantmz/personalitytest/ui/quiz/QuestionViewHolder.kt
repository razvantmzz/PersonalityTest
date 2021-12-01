package com.razvantmz.personalitytest.ui.quiz

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.razvantmz.personalitytest.databinding.ItemListQuizAnswerBinding
import com.razvantmz.personalitytest.models.Answer

interface QuestionViewHolderListener {
    fun onAnswerSelected(item: Answer)
}

class QuestionViewHolder(
    val binding: ItemListQuizAnswerBinding,
    private val listener: QuestionViewHolderListener?
) : RecyclerView.ViewHolder(binding.root) {
    var item: Answer? = null

    init {
        binding.answer.setOnClickListener {
            item?.let {
                listener?.onAnswerSelected(it)
            }
        }
    }

    fun bind(answer: Answer) {
        this.item = answer
        binding.answer.apply {
            text = answer.value
            setBackgroundColor(if (answer.isSelected) Color.RED else Color.WHITE)
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: QuestionViewHolderListener?): QuestionViewHolder {
            val binding = ItemListQuizAnswerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return QuestionViewHolder(binding, listener)
        }
    }
}