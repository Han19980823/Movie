package week1.dianshangjinjie.bw.com.demo2.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.demo2.apis.ApiService;
import week1.dianshangjinjie.bw.com.demo2.bean.Shop;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.utils.Utils;
import week1.dianshangjinjie.bw.com.demo2.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 11:21 modify by liujc
 */
public class Model {
    public void getUtils( Icontract.Imodel imodel){
        Utils.getInstance().getData(ApiService.class)
                .getSerVice(10155,"157440101550410155",1,5,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Shop>() {
                    @Override
                    public void accept(Shop shop) throws Exception {
                        imodel.getIshop(shop);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
