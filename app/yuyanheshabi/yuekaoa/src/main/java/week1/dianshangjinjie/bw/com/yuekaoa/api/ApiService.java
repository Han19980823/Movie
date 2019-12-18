package week1.dianshangjinjie.bw.com.yuekaoa.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 09:01 modify by liujc
 */
public interface ApiService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CarBean> getCar(@Header("userId") int uid, @Header("sessionId") String sid);
}
