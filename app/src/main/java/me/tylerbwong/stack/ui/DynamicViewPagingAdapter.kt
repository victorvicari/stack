package me.tylerbwong.stack.ui

import android.util.SparseArray
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import me.tylerbwong.stack.ui.questions.QuestionDataModel
import me.tylerbwong.stack.ui.utils.DynamicViewHolder
import me.tylerbwong.stack.ui.utils.ViewCreator

/**
 * TODO update adapter to support multiple data models
 */
class DynamicViewPagingAdapter : PagedListAdapter<QuestionDataModel, DynamicViewHolder>(DiffItemCallback()) {

    private val viewCreators = SparseArray<ViewCreator>()

    override fun getItemViewType(position: Int): Int {
        val currentData = getItem(position)
        val viewType = currentData?.viewType
        if (viewType != null && viewCreators.get(viewType) == null) {
            viewCreators.put(viewType, currentData.getViewCreator())
        }
        return viewType ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewCreators.get(viewType).invoke(parent)

    override fun onBindViewHolder(holder: DynamicViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class DiffItemCallback : DiffUtil.ItemCallback<QuestionDataModel>() {
        override fun areItemsTheSame(oldItem: QuestionDataModel, newItem: QuestionDataModel) =
                oldItem.areItemsThemSame(newItem)

        override fun areContentsTheSame(oldItem: QuestionDataModel, newItem: QuestionDataModel) =
                oldItem.areContentsTheSame(newItem)
    }
}