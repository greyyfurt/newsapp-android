package mobi.argun.newsapp_android.feature.presentation.favorites

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import mobi.argun.newsapp_android.core.base.BaseViewModel
import mobi.argun.newsapp_android.feature.domain.usecase.NewsUseCases
import mobi.argun.newsapp_android.feature.presentation.favorites.events.FavoritesUiState
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : BaseViewModel() {

    private val _state = mutableStateOf(FavoritesUiState())
    val state: State<FavoritesUiState> = _state

    private var getMyFavoritesJob: Job? = null

    init {
        getMyFavorites()
    }

    private fun getMyFavorites() {
        getMyFavoritesJob?.cancel()
        getMyFavoritesJob = newsUseCases.getMyFavoritesUseCase()
            .onEach { myFavoriteArticles ->
                _state.value = state.value.copy(
                    isEmpty = myFavoriteArticles.isEmpty(),
                    myFavoriteArticles = myFavoriteArticles
                )
            }.launchIn(viewModelScope)
    }

}