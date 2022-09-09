package mobi.argun.newsapp_android.core.util.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author greyyfurt
 * Created on 9.09.2022
 */
interface DispatcherProvider {
    val io: CoroutineDispatcher
    val ui: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}