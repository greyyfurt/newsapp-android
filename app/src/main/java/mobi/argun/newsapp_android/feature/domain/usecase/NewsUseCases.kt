package mobi.argun.newsapp_android.feature.domain.usecase

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val getMyFavoritesUseCase: GetMyFavoritesUseCase,
    val addToFavoritesUseCase: AddToFavoritesUseCase,
)