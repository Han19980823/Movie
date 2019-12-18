package week1.dianshangjinjie.bw.com.demo5.presenter;

import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo5.bean.ClzBean;
import week1.dianshangjinjie.bw.com.demo5.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo5.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo5.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo5.fragmrnt.CarFragment;
import week1.dianshangjinjie.bw.com.demo5.fragmrnt.ClzFragment;
import week1.dianshangjinjie.bw.com.demo5.model.Model;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:52 modify by liujc
 */
public class Presentert extends BasePresenter {
    Model model;

    public Presentert() {
        model = new Model();
    }

    public void getModel(){
        model.getUtils(new Icontract.Imode() {
            @Override
            public void success(ClzBean clzBean) {
                ClzFragment fragment = (ClzFragment) v;
                fragment.success(clzBean);
            }
        });
    }

    public void getMode(String id){
        model.getShop(id, new Icontract.IClzShop() {
            @Override
            public void success(ShopBean shopBean) {
                ClzFragment fragment = (ClzFragment) v;
                fragment.success(shopBean);
            }
        });
    }
    public void getCar(){
        model.getCar(new Icontract.ICar() {
            @Override
            public void success(CarBean carBean) {
                CarFragment fragment= (CarFragment) v;
                fragment.success(carBean);
            }
        });
    }
}
