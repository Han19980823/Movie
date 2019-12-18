package week1.dianshangjinjie.bw.com.demo1.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.demo1.CarBean;
import week1.dianshangjinjie.bw.com.demo1.apis.ApiService;
import week1.dianshangjinjie.bw.com.demo1.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo1.utils.Utils;
import week1.dianshangjinjie.bw.com.demo1.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 18:56 modify by liujc
 */
public class Model {

    public void getUtils(Icontract.Imodel imodel){
        Utils.getInstance().getData(ApiService.class)
                .getService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                    @Override
                    public void accept(CarBean carBean) throws Exception {
                        imodel.getNet(carBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
