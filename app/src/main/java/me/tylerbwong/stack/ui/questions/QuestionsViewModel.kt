package me.tylerbwong.stack.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.LivePagedListBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.tylerbwong.stack.data.model.CREATION
import me.tylerbwong.stack.data.model.Sort
import me.tylerbwong.stack.data.network.ServiceProvider
import me.tylerbwong.stack.data.network.service.QuestionService
import me.tylerbwong.stack.data.repository.QuestionRepository
import me.tylerbwong.stack.ui.BaseViewModel

internal class QuestionsViewModel(
        private val repository: QuestionRepository = QuestionRepository(),
        private val service: QuestionService = ServiceProvider.questionService
) : BaseViewModel() {

    private val currentSort = MutableLiveData<@Sort String>()
    internal val pagedQuestions = switchMap(currentSort) { currentSort ->
        val factory = repository.getPagedQuestionsFactory(uiScope, currentSort).map { QuestionDataModel(it) }
        LivePagedListBuilder(factory, PAGE_SIZE).build()
    }

    internal val questions: LiveData<List<QuestionDataModel>>
        get() = _questions
    private val _questions = MutableLiveData<List<QuestionDataModel>>()

    internal var currentQuery: String = ""

    internal fun getQuestions(@Sort sort: String) {
        currentSort.postValue(sort)
    }

    internal fun searchQuestions(query: String = currentQuery) {
        currentQuery = query
        launchRequest {
            _questions.value = withContext(Dispatchers.IO) {
                service.getQuestionsBySearchString(searchString = query)
                        .await()
                        .items
                        .map { QuestionDataModel(it) }
            }
        }
    }

    internal fun onStart() {
        if (currentQuery.isNotBlank()) {
            searchQuestions()
        } else {
            refreshQuestions()
        }
    }

    internal fun onQueryTextChange(newText: String?) {
        currentQuery = newText ?: ""

        if (currentQuery.isBlank()) {
            refreshQuestions()
        }
    }

    internal fun isQueryBlank() = currentQuery.isBlank()

    internal fun refreshQuestions() {
        currentSort.postValue(currentSort.value ?: CREATION)
    }

    companion object {
        private const val PAGE_SIZE = 30
    }
}
