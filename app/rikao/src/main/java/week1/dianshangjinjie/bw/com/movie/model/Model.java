package week1.dianshangjinjie.bw.com.movie.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.movie.BannerBean;
import week1.dianshangjinjie.bw.com.movie.Utils.Utils;
import week1.dianshangjinjie.bw.com.movie.apis.ApiService;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:06 modify by liujc
 */
public class Model  {

    public void getUtils(Icontract.Imodel imodel){
        Utils.getInstance().getService(ApiService.class)
                .data()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        imodel.success(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
