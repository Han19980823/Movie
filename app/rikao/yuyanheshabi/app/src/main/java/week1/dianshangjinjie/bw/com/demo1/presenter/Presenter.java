package week1.dianshangjinjie.bw.com.demo1.presenter;

import week1.dianshangjinjie.bw.com.demo1.CarBean;
import week1.dianshangjinjie.bw.com.demo1.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo1.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo1.model.Model;
import week1.dianshangjinjie.bw.com.demo1.view.MainActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/21
 * 描述：TODO
 * 最近修改：2019/11/21 18:56 modify by liujc
 */
public class Presenter extends BasePresenter {
    Model model;

    public Presenter() {
        model = new Model();
    }
    public void getModel(){

        model.getUtils(new Icontract.Imodel() {
            @Override
            public void getNet(CarBean carBean) {
                MainActivity activity = (MainActivity) v;
                activity.success(carBean);
            }
        });
    }
}
