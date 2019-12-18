package week1.dianshangjinjie.bw.com.demo4.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.demo4.api.ApiService;
import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo4.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo4.utils.Utils;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:10 modify by liujc
 */
public class Model {
    public void  getClzs(Icontract.ImodelClz imodelClz){
        Utils.getInstance().getData(ApiService.class)
                .getClz(10155,"157493680792110155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                        imodelClz.callBack(shopBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
    public void  getCars(Icontract.ImodelCar imodelCar){
        Utils.getInstance().getData(ApiService.class)
                .getCar(10155,"157493680792110155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                    @Override
                    public void accept(CarBean carBean) throws Exception {
                        imodelCar.callBack(carBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }


    public void  getPri(String cid,Icontract.IproDuct iproDuct){
        Utils.getInstance().getData(ApiService.class)
                .getPro(cid,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Product>() {
                    @Override
                    public void accept(Product product) throws Exception {
                        iproDuct.callBazk(product);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }

                });
    }

}
