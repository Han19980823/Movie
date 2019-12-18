package week1.dianshangjinjie.bw.com.demo5.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo5.bean.ClzBean;
import week1.dianshangjinjie.bw.com.demo5.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:53 modify by liujc
 */
public interface ApiService {
    @GET("small/commodity/v1/findCategory")
    Observable<ClzBean> getService();
    @GET("small/commodity/v1/findCommodityByCategory")
    Observable<ShopBean> getData(@Query("categoryId") String sid,@Query("page") int page,@Query("count") int count);
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CarBean> getCar(@Header("userId") int uid,@Header("sessionId") String sid);
}
