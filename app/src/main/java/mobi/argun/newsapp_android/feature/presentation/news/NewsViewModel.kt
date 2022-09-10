package mobi.argun.newsapp_android.feature.presentation.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mobi.argun.newsapp_android.core.base.BaseViewModel
import mobi.argun.newsapp_android.core.util.Empty
import mobi.argun.newsapp_android.core.util.Error
import mobi.argun.newsapp_android.core.util.Loading
import mobi.argun.newsapp_android.core.util.Success
import mobi.argun.newsapp_android.feature.domain.usecase.GetNewsUseCase
import mobi.argun.newsapp_android.feature.presentation.news.events.NewsServicesState
import mobi.argun.newsapp_android.feature.presentation.news.events.NewsUiEvents
import javax.inject.Inject

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
) : BaseViewModel() {

    private var curPage = 1

    private val _state = mutableStateOf(NewsServicesState())
    val state: State<NewsServicesState> = _state

    fun onEvent(event: NewsUiEvents) {
        viewModelScope.launch {
            getNewsUseCase.invoke(curPage).onEach { dataResult ->
                _state.value = when(dataResult) {
                    Empty ->
                        state.value.copy(
                            isLoading = false,
                            isEmpty = true,
                            errMessage = "",
                            articles = null
                        )
                    is Error ->
                        state.value.copy(
                            isLoading = false,
                            isEmpty = false,
                            errMessage = dataResult.errorMessage
                                ?: "Something went wrong",
                            articles = null
                        )
                    Loading ->
                        state.value.copy(
                            isLoading = true,
                            isEmpty = false,
                            errMessage = "",
                            articles = null
                        )
                    is Success ->
                        state.value.copy(
                            isLoading = false,
                            isEmpty = false,
                            errMessage = "",
                            articles = dataResult.data?.articles
                        )
                }
            }.launchIn(this)
        }
    }
}