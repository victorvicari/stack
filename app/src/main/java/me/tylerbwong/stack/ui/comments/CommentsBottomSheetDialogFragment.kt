package me.tylerbwong.stack.ui.comments

import android.app.Dialog
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.comments_fragment.*
import kotlinx.android.synthetic.main.header_holder.*
import me.tylerbwong.stack.R
import me.tylerbwong.stack.ui.ApplicationWrapper
import javax.inject.Inject

class CommentsBottomSheetDialogFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var viewModelFactory: CommentsViewModelFactory

    private val viewModel by viewModels<CommentsViewModel> { viewModelFactory }
    private val adapter = CommentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationWrapper.uiComponent.inject(this)
        viewModel.postId = arguments?.getInt(POST_ID) ?: -1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.comments_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.apply {
            adapter = this@CommentsBottomSheetDialogFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
        title.text = getString(R.string.comments)
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            subtitle.text = getString(R.string.comment_count, it.size)
            emptySpace.isVisible = it.isEmpty()
        }

        viewModel.fetchComments()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val bottomSheet = dialog.findViewById<ViewGroup>(
            com.google.android.material.R.id.design_bottom_sheet
        )
        if (bottomSheet != null) {
            BottomSheetBehavior.from(bottomSheet).apply {
                isGestureInsetBottomIgnored = true
            }
        }

        // Prevent peeking when in landscape to avoid only showing top of bottom sheet
        if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            dialog.setOnShowListener {
                bottomSheet?.let {
                    with(BottomSheetBehavior.from(bottomSheet)) {
                        peekHeight = bottomSheet.height
                        state = BottomSheetBehavior.STATE_EXPANDED
                    }
                }
            }
        } else {
            dialog.setOnShowListener(null)
        }
        return dialog
    }

    companion object {
        private const val POST_ID = "post_id"

        fun show(fragmentManager: FragmentManager, postId: Int) {
            val fragment = CommentsBottomSheetDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(POST_ID, postId)
                }
            }
            fragment.show(fragmentManager, CommentsBottomSheetDialogFragment::class.java.simpleName)
        }
    }
}
