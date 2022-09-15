package mobi.argun.newsapp_android.feature.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mobi.argun.newsapp_android.feature.data.source.util.Converters
import mobi.argun.newsapp_android.feature.domain.entity.Article

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