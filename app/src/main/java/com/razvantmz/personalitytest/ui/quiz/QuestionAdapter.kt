package com.razvantmz.personalitytest.ui.quiz

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.razvantmz.personalitytest.models.Answer

interface QuestionAdapterListener {
    fun onAnswerSelected(item: Answer)
}

class QuestionAdapter(var items:List<Answer>, listener: QuestionAdapterListener?) : RecyclerView.Adapter<QuestionViewHolder>() {
    private val questionViewHolderListener by lazy {
        object : QuestionViewHolderListener {
            override fun onAnswerSelected(item: Answer) {
                listener?.onAnswerSelected(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder.create(parent, questionViewHolderListener)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun updateItems(items:List<Answer>) {
        this.items = items
        notifyDataSetChanged()
    }
}