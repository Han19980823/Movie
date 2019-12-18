package week1.dianshangjinjie.bw.com.demo2.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import week1.dianshangjinjie.bw.com.demo2.bean.Shop;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 11:26 modify by liujc
 */
public interface ApiService   {
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<Shop> getSerVice(@Header("userId") int uid, @Header("sessionId") String sid, @Query("status") int num,@Query("page") int page,@Query("count") int count);

}
