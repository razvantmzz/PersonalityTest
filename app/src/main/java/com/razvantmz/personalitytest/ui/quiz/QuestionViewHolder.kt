package com.razvantmz.personalitytest.ui.quiz

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.shape.MaterialShapeDrawable
import com.razvantmz.personalitytest.databinding.ItemListQuizAnswerBinding
import com.razvantmz.personalitytest.models.Answer

interface QuestionViewHolderListener {
    fun onAnswerSelected(item: Answer)
}

class QuestionViewHolder(
    private val binding: ItemListQuizAnswerBinding,
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
            background = getBackground(answer.isSelected)
        }
    }

    private fun getBackground(isSelected: Boolean): MaterialShapeDrawable {
        val cornerSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, binding.root.context.resources.displayMetrics)
        val shape = MaterialShapeDrawable()
        shape.strokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, binding.root.context.resources.displayMetrics)
        shape.strokeColor = ColorStateList.valueOf(Color.BLACK)
        shape.fillColor = ColorStateList.valueOf((if (isSelected) Color.RED else Color.WHITE))
        shape.setCornerSize(cornerSize)
        return shape
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