package week1.dianshangjinjie.bw.com.demo5.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo5.bean.ClzBean;
import week1.dianshangjinjie.bw.com.demo5.api.ApiService;
import week1.dianshangjinjie.bw.com.demo5.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo5.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo5.utils.Utils;
import week1.dianshangjinjie.bw.com.demo5.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:52 modify by liujc
 */
public class Model {

    public void getUtils(Icontract.Imode imode){
        Utils.getInstance().getData(ApiService.class)
                .getService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ClzBean>() {
                    @Override
                    public void accept(ClzBean clzBean) throws Exception {
                        imode.success(clzBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void getShop(String id,Icontract.IClzShop shop){
        Utils.getInstance().getData(ApiService.class)
                .getData(id,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                        shop.success(shopBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void  getCar(Icontract.ICar iCar){
        Utils.getInstance().getData(ApiService.class)
                .getCar(10155,"157493680792110155")
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
}
