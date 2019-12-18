package week1.dianshangjinjie.bw.com.demo1.apis;

import io.reactivex.Observable;
import retrofit2.http.GET;
import week1.dianshangjinjie.bw.com.demo1.CarBean;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 19:03 modify by liujc
 */
public interface ApiService {
    @GET("small/commodity/v1/findCategory")
    Observable<CarBean> getService();
}
