package mobi.argun.newsapp_android.core.vo

/**
 * @author greyyfurt
 * Created on 10.09.2022
 */
fun String?.splitByCharacter(c: Char): String {
    if (this == null)
        return ""
    return this.split(c).firstOrNull() ?: ""
}