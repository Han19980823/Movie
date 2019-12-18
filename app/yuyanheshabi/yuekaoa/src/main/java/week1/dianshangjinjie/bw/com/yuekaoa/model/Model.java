package week1.dianshangjinjie.bw.com.yuekaoa.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.yuekaoa.api.ApiService;
import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;
import week1.dianshangjinjie.bw.com.yuekaoa.contract.Icontrract;
import week1.dianshangjinjie.bw.com.yuekaoa.utils.Utils;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 08:42 modify by liujc
 */
public class Model {
    public void getUtils(Icontrract.Imdel imdel){
        Utils.getInstance().getData(ApiService.class)
                .getCar(10155,"157474793553110155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                    @Override
                    public void accept(CarBean carBean) throws Exception {
                        imdel.success(carBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
