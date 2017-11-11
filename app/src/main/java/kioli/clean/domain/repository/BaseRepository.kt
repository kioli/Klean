package kioli.clean.domain.repository

import android.support.v4.util.LruCache
import io.reactivex.Observable

internal abstract class BaseRepository {

    private val observablesCache: LruCache<String, Observable<*>> = LruCache(50)

    fun <T> cacheObservable(symbol: String, observable: Observable<T>): Observable<T>? {
        var cachedObservable = observablesCache.get(symbol)
        if (cachedObservable == null) {
            cachedObservable = observable
            updateCache(symbol, cachedObservable)
        }
        return cachedObservable as Observable<T>
    }

    private fun <T> updateCache(stockSymbol: String, observable: Observable<T>?) {
        observablesCache.put(stockSymbol, observable)
    }
}