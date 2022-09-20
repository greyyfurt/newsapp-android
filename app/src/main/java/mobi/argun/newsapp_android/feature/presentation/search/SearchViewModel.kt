package mobi.argun.newsapp_android.feature.presentation.search

import dagger.hilt.android.lifecycle.HiltViewModel
import mobi.argun.newsapp_android.core.base.BaseViewModel
import mobi.argun.newsapp_android.feature.domain.usecase.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): BaseViewModel() {

}