package week1.dianshangjinjie.bw.com.yuekaoa.presenter;

import week1.dianshangjinjie.bw.com.yuekaoa.base.BasePresenter;
import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;
import week1.dianshangjinjie.bw.com.yuekaoa.contract.Icontrract;
import week1.dianshangjinjie.bw.com.yuekaoa.model.Model;
import week1.dianshangjinjie.bw.com.yuekaoa.view.MainActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/26
 * 描述：TODO
 * 最近修改：2019/11/26 08:41 modify by liujc
 */
public class Presenter extends BasePresenter {
    Model model;

    public Presenter() {
       model = new Model();
    }
    public void getModel(){
        model.getUtils(new Icontrract.Imdel() {
            @Override
            public void success(CarBean carBean) {
                MainActivity activity = (MainActivity) v;
                activity.success(carBean);
            }
        });
    }
}
