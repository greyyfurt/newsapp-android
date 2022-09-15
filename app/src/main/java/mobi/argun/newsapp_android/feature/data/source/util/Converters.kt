package mobi.argun.newsapp_android.feature.data.source.util

import androidx.room.TypeConverter
import mobi.argun.newsapp_android.feature.domain.entity.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name.orEmpty()
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}