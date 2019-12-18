package week1.dianshangjinjie.bw.com.movie.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import week1.dianshangjinjie.bw.com.movie.BannerBean;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:05 modify by liujc
 */
public interface ApiService {
    @GET("small/commodity/v1/bannerShow")
    Observable<BannerBean> data();
}
