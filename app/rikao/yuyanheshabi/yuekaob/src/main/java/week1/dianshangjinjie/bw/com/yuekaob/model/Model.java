package week1.dianshangjinjie.bw.com.yuekaob.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.yuekaob.api.Api;
import week1.dianshangjinjie.bw.com.yuekaob.api.ApiService;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ChaBean;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ShopBean;
import week1.dianshangjinjie.bw.com.yuekaob.contract.Icontrract;
import week1.dianshangjinjie.bw.com.yuekaob.utils.Utils;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 08:42 modify by liujc
 */
public class Model {
    public void getUtils(Icontrract.IModel imdel) {
        Utils.getInstance().getData(ApiService.class)
                .getShop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                        imdel.success(shopBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void getCha(String id, Icontrract.ICha iCha) {
        Utils.getInstance().getData(ApiService.class)
                .getCha(id, 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChaBean>() {
                    @Override
                    public void accept(ChaBean chaBean) throws Exception {
                        iCha.success(chaBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
