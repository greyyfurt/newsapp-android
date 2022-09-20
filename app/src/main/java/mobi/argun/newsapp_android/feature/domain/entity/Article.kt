package mobi.argun.newsapp_android.feature.domain.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    indices = [
        Index(
            value = ["title", "description"],
            unique = true
        )
    ]
)
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
    var isMyFav: Boolean = false,
    @PrimaryKey(autoGenerate = true) var id: Int? = null
) : Serializable