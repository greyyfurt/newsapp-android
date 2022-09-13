package mobi.argun.newsapp_android.feature.domain.util

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
}