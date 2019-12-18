package week1.dianshangjinjie.bw.com.movie.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import week1.dianshangjinjie.bw.com.movie.apis.Api;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:00 modify by liujc
 */
public class Utils {
    public static Utils utils;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private Utils(){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//网络拦截器
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//应用拦截器
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
    public static Utils getInstance(){
        if (utils==null){
            synchronized (Utils.class){
                if (utils == null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }

    /**
     * 动态代理模式
     * @param clz
     * @param <T>
     * @return
     */
    public <T> T getService(Class<T> clz){
        return  retrofit.create(clz);
    }

}
