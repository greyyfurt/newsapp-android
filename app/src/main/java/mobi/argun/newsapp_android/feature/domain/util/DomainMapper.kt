package mobi.argun.newsapp_android.feature.domain.util

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
}