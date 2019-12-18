package week1.dianshangjinjie.bw.com.demo4.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;

public interface ApiService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CarBean> getCar(@Header("userId") int uid, @Header("sessionId") String sid);
    @GET("small/commodity/v1/findCategory")
    Observable<ShopBean> getClz(@Header("userId") int uid, @Header("sessionId") String sid);
    @GET("small/commodity/v1/findCommodityByCategory")
    Observable<Product> getPro(@Query("categoryId")String cid,@Query("page") int page,@Query("count") int count);
}
