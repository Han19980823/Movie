package week1.dianshangjinjie.bw.com.demo3.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.demo3.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:23 modify by liujc
 */
public interface ApiService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CarBean> getCar(@Header("userId") int uid, @Header("sessionId") String sid);
    @GET("small/commodity/v1/findCategory")
    Observable<ShopBean> getClz(@Header("userId") int uid, @Header("sessionId") String sid);
}
