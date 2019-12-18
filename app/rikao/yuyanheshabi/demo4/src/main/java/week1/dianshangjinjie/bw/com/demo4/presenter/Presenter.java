package week1.dianshangjinjie.bw.com.demo4.presenter;

import week1.dianshangjinjie.bw.com.demo4.base.mvp.BasePresenter;
import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.bean.Product;
import week1.dianshangjinjie.bw.com.demo4.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo4.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo4.fragment.CarFragment;
import week1.dianshangjinjie.bw.com.demo4.fragment.ClzFragment;
import week1.dianshangjinjie.bw.com.demo4.model.Model;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:09 modify by liujc
 */
public class Presenter extends BasePresenter {

    Model model;

    public Presenter() {
        model = new Model();
    }

    public void getClz(){
        model.getClzs(new Icontract.ImodelClz() {
            @Override
            public void callBack(ShopBean shopBean) {
                ClzFragment fragment = (ClzFragment) v;
                fragment.success(shopBean);
            }
        });


    }
    public void getCar(){

            model.getCars(new Icontract.ImodelCar() {
                @Override
                public void callBack(CarBean carBean) {
                    CarFragment fragment = (CarFragment) v;
                    fragment.success(carBean);
                }
            });

    }

    public void getPro(String cid){
        model.getPri(cid, new Icontract.IproDuct() {
            @Override
            public void callBazk(Product product) {
                ClzFragment fragment = (ClzFragment) v;
                fragment.sucesse(product);
            }
        });
    }
}
