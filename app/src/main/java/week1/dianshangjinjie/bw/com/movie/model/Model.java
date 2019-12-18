package week1.dianshangjinjie.bw.com.movie.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.movie.bean.BannerBean;
import week1.dianshangjinjie.bw.com.movie.Utils.Utils;
import week1.dianshangjinjie.bw.com.movie.apis.ApiService;
import week1.dianshangjinjie.bw.com.movie.bean.CardBean;
import week1.dianshangjinjie.bw.com.movie.bean.HomeBean;
import week1.dianshangjinjie.bw.com.movie.bean.LoginBean;
import week1.dianshangjinjie.bw.com.movie.bean.RegistBean;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:06 modify by liujc
 */
public class Model  {

    public void getUtils(String phone,String pwd,Icontract.Imodel imodel){
        Utils.getInstance().getService(ApiService.class)
                .regist(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegistBean>() {
                    @Override
                    public void accept(RegistBean registBean) throws Exception {
                        imodel.success(registBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void Login(String phone,String pwd,Icontract.Ilogin ilogin){
        Utils.getInstance().getService(ApiService.class)
                .login(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        ilogin.success(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
    public void banner(Icontract.Ibanner ibanner){
        Utils.getInstance().getService(ApiService.class)
                .data()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        ibanner.success(bannerBean);
                    }
                });
    }
    public void home (Icontract.IHome home){
        Utils.getInstance().getService(ApiService.class)
                .home()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        home.success(homeBean);
                    }
                });
    }

    public void getCar(Icontract.ICas ica){
        Utils.getInstance().getService(ApiService.class)
                .
                car(10155,"157663059124410155")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CardBean>() {
                    @Override
                    public void accept(CardBean cardBean) throws Exception {
                        ica.success(cardBean);
                    }
                });
    }
}
