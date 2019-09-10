package me.tylerbwong.stack.ui.comments

import me.tylerbwong.stack.data.model.Comment
import me.tylerbwong.stack.ui.utils.DynamicDataModel

class CommentDataModel(comment: Comment) : DynamicDataModel() {

    internal val commentId = comment.commentId
    internal val bodyMarkdown = comment.bodyMarkdown
    internal val creationDate = comment.creationDate
    internal val edited = comment.edited
    internal val owner = comment.owner
    internal val score = comment.score

    override fun areItemsThemSame(
            other: DynamicDataModel
    ) = other is CommentDataModel && other.commentId == commentId

    override fun areContentsTheSame(
            other: DynamicDataModel
    ) = other is CommentDataModel && other.bodyMarkdown == bodyMarkdown
            && other.creationDate == creationDate
            && other.edited == edited && other.owner == owner
            && other.score == score

    override fun getViewCreator() = ::CommentsHolder
}