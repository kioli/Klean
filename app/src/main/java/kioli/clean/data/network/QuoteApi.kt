package kioli.clean.data.network

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
class QuoteApi {

    private val endpoint = "http://api.forismatic.com/api/1.0/"
    private val api: QuoteRestInterface

    init {
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

//        if (BuildConfig.DEBUG) {
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//            retrofitBuilder?.client(client)
//        }

        api = retrofitBuilder
                .build()
                .create(QuoteRestInterface::class.java)
    }

    fun getQuote(): Observable<Quote> {
        return api.loadQuote()
    }
}