package me.tylerbwong.stack.data.repository

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.tylerbwong.stack.data.model.Question
import me.tylerbwong.stack.data.model.Sort
import timber.log.Timber

class QuestionDataSource(private val scope: CoroutineScope,
                         private val questionRepository: QuestionRepository,
                         @Sort private val sort: String) : PageKeyedDataSource<Int, Question>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Question>) {
        Timber.d("QuestionDataSource: loadInitial")
        scope.launch {
            val result = withContext(Dispatchers.IO) {
                questionRepository.getPagedQuestions(sort = sort, pageSize = params.requestedLoadSize, page = 1)
            }
            callback.onResult(result, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Question>) {
        Timber.d("QuestionDataSource: loadAfter Params.key = ${params.key}")
        scope.launch {
            val result = withContext(Dispatchers.IO) {
                questionRepository.getPagedQuestions(sort = sort, pageSize = params.requestedLoadSize, page = params.key)
            }
            callback.onResult(result, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Question>) {
        Timber.d("QuestionDataSource: loadBefore Params.key = ${params.key}")
        // do nothing
    }
}