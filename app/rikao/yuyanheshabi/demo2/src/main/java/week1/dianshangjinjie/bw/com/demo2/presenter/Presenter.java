package week1.dianshangjinjie.bw.com.demo2.presenter;

import week1.dianshangjinjie.bw.com.demo2.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo2.bean.Shop;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.model.Model;
import week1.dianshangjinjie.bw.com.demo2.view.MainActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 11:17 modify by liujc
 */
public class Presenter extends BasePresenter {
    Model model;

    public Presenter() {
        model =new Model();
    }

    public  void  getModel(){
        model.getUtils(new Icontract.Imodel() {
            @Override
            public void getIshop(Shop shop) {
                MainActivity activity = (MainActivity) v;
                activity.successs(shop);
            }
        });
    }
}
