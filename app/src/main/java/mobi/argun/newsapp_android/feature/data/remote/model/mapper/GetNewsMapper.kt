package mobi.argun.newsapp_android.feature.data.remote.model.mapper

import mobi.argun.newsapp_android.feature.data.remote.model.response.GetNewsDto
import mobi.argun.newsapp_android.feature.domain.entity.Article
import mobi.argun.newsapp_android.feature.domain.entity.GetNews
import mobi.argun.newsapp_android.feature.domain.entity.Source
import mobi.argun.newsapp_android.feature.domain.util.DomainMapper

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
class GetNewsMapper : DomainMapper<GetNewsDto, GetNews> {

    override fun mapToDomainModel(model: GetNewsDto): GetNews =
        GetNews(
            status = model.status,
            totalResults = model.totalResults,
            articles = model.articles?.map { articleDto ->
                Article(
                    author = articleDto.author,
                    content = articleDto.content,
                    description = articleDto.description,
                    publishedAt = articleDto.publishedAt,
                    title = articleDto.title,
                    url = articleDto.url,
                    urlToImage = articleDto.urlToImage,
                    source = articleDto.source?.let { sourceDto ->
                        Source(
                            id = sourceDto.id,
                            name = sourceDto.name
                        )
                    }
                )
            }
        )
}