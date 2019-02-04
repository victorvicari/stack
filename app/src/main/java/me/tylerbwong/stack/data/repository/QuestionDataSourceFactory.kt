package me.tylerbwong.stack.data.repository

import androidx.paging.DataSource
import kotlinx.coroutines.CoroutineScope
import me.tylerbwong.stack.data.model.Question
import me.tylerbwong.stack.data.model.Sort

class QuestionDataSourceFactory(private val scope: CoroutineScope,
                                private val questionRepository: QuestionRepository,
                                @Sort private val sort: String) : DataSource.Factory<Int, Question>() {

    override fun create() = QuestionDataSource(scope, questionRepository, sort)
}