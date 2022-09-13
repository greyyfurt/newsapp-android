package mobi.argun.newsapp_android.feature.data.source

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import mobi.argun.newsapp_android.feature.domain.entity.Article

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>

    @Query("SELECT * FROM article WHERE id = :id")
    fun getArticleById(id: Int): Article?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)
}