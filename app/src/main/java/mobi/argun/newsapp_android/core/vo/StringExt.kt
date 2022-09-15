package mobi.argun.newsapp_android.core.vo

fun String?.splitByCharacter(c: Char): String {
    if (this == null)
        return ""
    return this.split(c).firstOrNull() ?: ""
}