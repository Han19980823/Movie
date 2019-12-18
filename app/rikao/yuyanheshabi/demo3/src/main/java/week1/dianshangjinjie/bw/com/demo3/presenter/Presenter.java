package week1.dianshangjinjie.bw.com.demo3.presenter;

import week1.dianshangjinjie.bw.com.demo3.base.mvp.BasePresenter;
import week1.dianshangjinjie.bw.com.demo3.bean.CarBean;

import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo3.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo3.fragment.CarFragment;
import week1.dianshangjinjie.bw.com.demo3.fragment.ClzFragment;
import week1.dianshangjinjie.bw.com.demo3.model.Model;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:10 modify by liujc
 */
public class Presenter extends BasePresenter {
    Model model;

    public Presenter() {
        model = new Model();
    }

    /**
     * 购物车
     */
    public void getModel(){
        model.getUitlsCar(new Icontract.ICar() {
            @Override
            public void success(CarBean carBean) {
                CarFragment fragment = (CarFragment) v;
                fragment.success(carBean);
            }
        });
    }

    /**
     * 分类
     *
     */
    public void getClzB(){
       model.getUitlsClz(new Icontract.IClz() {
           @Override
           public void success(ShopBean clzBean) {
               ClzFragment fragment = (ClzFragment) v;
               fragment.success(clzBean);
           }
       });
    }
}
