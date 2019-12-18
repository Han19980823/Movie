package week1.dianshangjinjie.bw.com.demo2.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import week1.dianshangjinjie.bw.com.demo2.apis.Apis;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 11:22 modify by liujc
 */
public class Utils {
    public static  Utils utils;
    public OkHttpClient okHttpClient;
    public Retrofit retrofit;
    private Utils(){
        okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apis.BASE_URI)
                .client(okHttpClient)
                .build();
    }
    public static Utils getInstance(){
        if (utils == null){
            synchronized (Utils.class){
                if (utils ==null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }

    public <T> T getData(Class<T> clz){
        return  retrofit.create(clz);
    }
}
