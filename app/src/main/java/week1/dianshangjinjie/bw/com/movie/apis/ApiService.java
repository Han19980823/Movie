package week1.dianshangjinjie.bw.com.movie.apis;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import week1.dianshangjinjie.bw.com.movie.bean.BannerBean;
import week1.dianshangjinjie.bw.com.movie.bean.CardBean;
import week1.dianshangjinjie.bw.com.movie.bean.HomeBean;
import week1.dianshangjinjie.bw.com.movie.bean.LoginBean;
import week1.dianshangjinjie.bw.com.movie.bean.RegistBean;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:05 modify by liujc
 */
public interface ApiService {
    @GET("small/commodity/v1/bannerShow")
    Observable<BannerBean> data();
    @POST("small/user/v1/register")
    @FormUrlEncoded
    Observable<RegistBean> regist(@Field("phone") String phone,@Field("pwd") String pwd);
    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("phone") String phone, @Field("pwd") String pwd);
    @GET("small/commodity/v1/commodityList")
    Observable<HomeBean> home();
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CardBean> car (@Header("userId") int uid,@Header("sessionId") String sid);
}
