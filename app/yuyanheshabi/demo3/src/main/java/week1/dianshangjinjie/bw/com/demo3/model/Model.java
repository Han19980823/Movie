package week1.dianshangjinjie.bw.com.demo3.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.demo3.apis.Api;
import week1.dianshangjinjie.bw.com.demo3.apis.ApiService;
import week1.dianshangjinjie.bw.com.demo3.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo3.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo3.utils.Utils;
import week1.dianshangjinjie.bw.com.demo3.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:10 modify by liujc
 */
public class Model {
    /**
     * 购物车
     * @param iCar
     */
    public void getUitlsCar(final Icontract.ICar iCar){
        Utils.getInstance().getData(ApiService.class)
                .getCar(10155,"157442171144710155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                    @Override
                    public void accept(CarBean carBean) throws Exception {
                        iCar.success(carBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * 分类
     * @param iClz
     */
    public void getUitlsClz(final Icontract.IClz iClz){
        Utils.getInstance().getData(ApiService.class)
                .getClz(10155,"157442171144710155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                        iClz.success(shopBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
