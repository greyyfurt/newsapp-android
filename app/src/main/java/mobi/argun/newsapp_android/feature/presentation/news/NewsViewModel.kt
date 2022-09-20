package mobi.argun.newsapp_android.feature.presentation.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mobi.argun.newsapp_android.core.base.BaseViewModel
import mobi.argun.newsapp_android.core.util.*
import mobi.argun.newsapp_android.feature.domain.usecase.NewsUseCases
import mobi.argun.newsapp_android.feature.presentation.news.events.NewsServicesState
import mobi.argun.newsapp_android.feature.presentation.news.events.NewsUiEvents
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : BaseViewModel() {

    private val _state = mutableStateOf(NewsServicesState())
    val state: State<NewsServicesState> = _state

    private var getServicesJob: Job? = null

    init {
        getBreakingNews()
    }

    private fun getBreakingNews() {
        getServicesJob?.cancel()

        viewModelScope.launch {
            getServicesJob =
                newsUseCases.getNewsUseCase(state.value.page).onEach { dataResult ->
                    _state.value = when (dataResult) {
                        Empty ->
                            state.value.copy(
                                isLoading = false,
                                isEmpty = true,
                                errMessage = "",
                            )
                        is Error ->
                            state.value.copy(
                                isLoading = false,
                                isEmpty = false,
                                errMessage = dataResult.errorMessage
                                    ?: "Something went wrong",
                            )
                        Loading ->
                            state.value.copy(
                                isLoading = true,
                                isEmpty = false,
                                errMessage = "",
                            )
                        is Success -> when {
                            dataResult.data?.totalResults == null || dataResult.data.articles == null -> state.value.copy(
                                isLoading = false,
                                isEmpty = false,
                                errMessage = ""
                            )
                            else -> {
                                state.value.copy(
                                    isLoading = false,
                                    isEmpty = false,
                                    errMessage = "",
                                    page = state.value.page + 1,
                                    articles = state.value.articles.plus(dataResult.data.articles),
                                    endReached = state.value.page * Constants.PAGE_SIZE >= dataResult.data.totalResults
                                )
                            }
                        }
                    }
                }.launchIn(this)
        }
    }

    fun onEvent(event: NewsUiEvents) {
        viewModelScope.launch {
            when (event) {
                NewsUiEvents.LoadMoreNews -> {
                    getBreakingNews()
                }
            }
        }
    }
}