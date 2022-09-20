package mobi.argun.newsapp_android.feature.presentation.newsdetail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import mobi.argun.newsapp_android.core.base.BaseViewModel
import mobi.argun.newsapp_android.feature.domain.usecase.NewsUseCases
import mobi.argun.newsapp_android.feature.presentation.newsdetail.events.NewsDetailReUiEvents
import mobi.argun.newsapp_android.feature.presentation.newsdetail.events.NewsDetailUiEvents
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): BaseViewModel() {

    private val _eventFlow = MutableSharedFlow<NewsDetailReUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: NewsDetailUiEvents) {
        viewModelScope.launch {
            when(event) {
                is NewsDetailUiEvents.AddToFavorites -> {
                    newsUseCases.addToFavoritesUseCase(event.article)
                    _eventFlow.emit(NewsDetailReUiEvents.ShowSnackBar("Added to Your Favorites"))
                }
            }
        }
    }
}