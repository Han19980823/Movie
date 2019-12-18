package week1.dianshangjinjie.bw.com.yuekaob.api;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ChaBean;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ShopBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 09:01 modify by liujc
 */
public interface ApiService {
    @GET("small/commodity/v1/findCategory")
    Observable<ShopBean> getShop();

    @GET("small/commodity/v1/findCommodityByCategory")
    Observable<ChaBean> getCha(@Query("categoryId") String id, @Query("page") int uid, @Query("count") int count);
}
