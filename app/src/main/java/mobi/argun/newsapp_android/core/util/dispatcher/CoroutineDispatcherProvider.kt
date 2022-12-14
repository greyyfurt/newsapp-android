package mobi.argun.newsapp_android.core.util.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

open class CoroutineDispatcherProvider : DispatcherProvider {
    override val ui: CoroutineDispatcher by lazy { Dispatchers.Main }
    override val io: CoroutineDispatcher by lazy { Dispatchers.IO }
    override val default: CoroutineDispatcher by lazy { Dispatchers.Default }
    override val unconfined: CoroutineDispatcher by lazy { Dispatchers.Unconfined }
}