package com.vergil.base.network

import android.text.TextUtils
import com.vergil.base.utils.Constant
import com.vergil.mvvmlazy.base.appContext
import com.vergil.mvvmlazy.http.cookie.CookieJarImpl
import com.vergil.mvvmlazy.http.cookie.store.PersistentCookieStore
import com.vergil.mvvmlazy.http.interceptor.BaseInterceptor
import com.vergil.mvvmlazy.http.interceptor.CacheInterceptor
import com.vergil.mvvmlazy.http.interceptor.logging.Level
import com.vergil.mvvmlazy.http.interceptor.logging.LoggingInterceptor
import com.vergil.mvvmlazy.utils.app.ProcessUtils
import com.vergil.mvvmlazy.utils.common.KLog
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform.Companion.INFO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * *******************************
 * *@Author
 * *date ：
 * *description:RetrofitClient封装单例类, 实现网络请求
 * *******************************
 */
class RetrofitClient(
    url: String = ApiUrl,
    headers: Map<String, String>? = null
) {
    private var cache: Cache? = null
    private var httpCacheDirectory: File? = null

    /**
     * create you ApiService
     * Create an implementation of the API endpoints defined by the `service` interface.
     */
    fun <T> create(service: Class<T>?): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit.create(service)
    }

    companion object {
        val instance by lazy {
            RetrofitClient()
        }

        //超时时间
        private const val DEFAULT_TIMEOUT = 20
        private const val DEFAULT_READTIMEOUT = 2

        //缓存时间
        private const val CACHE_TIMEOUT = 10 * 1024 * 1024

        //服务端根路径
        var ApiUrl = Constant.baseUrl
        private lateinit var okHttpClient: OkHttpClient
        private lateinit var retrofit: Retrofit
    }

    init {
        var url: String? = url
        if (TextUtils.isEmpty(url)) {
            url = ApiUrl
        }
        if (httpCacheDirectory == null) {
            httpCacheDirectory = File(appContext.cacheDir, "goldze_cache")
        }
        try {
            if (cache == null) {
                cache = Cache(httpCacheDirectory!!, CACHE_TIMEOUT.toLong())
            }
        } catch (e: Exception) {
            KLog.e("Could not create http cache", e)
        }
        val sslParams: HttpsUtils.SSLParams = HttpsUtils.getSslSocketFactory()
        okHttpClient = OkHttpClient.Builder()
            .cookieJar(CookieJarImpl(PersistentCookieStore(appContext)))
            .cache(cache)
            .addInterceptor(BaseInterceptor(headers))
            .addInterceptor(CacheInterceptor(appContext))
            .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
            .addInterceptor(
                LoggingInterceptor.Builder() //构建者模式
                    .loggable(ProcessUtils.isApkInDebug()) //是否开启日志打印
                    .setLevel(Level.BASIC) //打印的等级
                    .log(INFO) // 打印类型
                    .request("Request") // request的Tag
                    .response("Response") // Response的Tag
                    .addHeader(
                        "log-header",
                        "I am the log request header."
                    ) // 添加打印头, 注意 key 和 value 都不能是中文
                    .build()
            )
            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_READTIMEOUT.toLong(), TimeUnit.MINUTES)
            .readTimeout(DEFAULT_READTIMEOUT.toLong(), TimeUnit.MINUTES)
            .connectionPool(
                ConnectionPool(
                    8,
                    15,
                    TimeUnit.SECONDS
                )
            ) // 这里你可以根据自己的机型设置同时连接的个数和时间，我这里8个，和每个保持时间为10s
            .build()
        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
    }
}