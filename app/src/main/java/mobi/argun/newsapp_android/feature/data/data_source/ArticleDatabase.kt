package mobi.argun.newsapp_android.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mobi.argun.newsapp_android.feature.data.data_source.util.Converters
import mobi.argun.newsapp_android.feature.domain.entity.Article

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract val articleDao : ArticleDao

    companion object {
        const val DATABASE_NAME = "article_db"
    }
}