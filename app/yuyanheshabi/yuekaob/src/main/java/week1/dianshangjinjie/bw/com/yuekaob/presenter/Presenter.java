package week1.dianshangjinjie.bw.com.yuekaob.presenter;

import week1.dianshangjinjie.bw.com.yuekaob.base.BasePresenter;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ChaBean;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ShopBean;
import week1.dianshangjinjie.bw.com.yuekaob.contract.Icontrract;
import week1.dianshangjinjie.bw.com.yuekaob.model.Model;
import week1.dianshangjinjie.bw.com.yuekaob.view.MainActivity;

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

    public void getModel() {
        model.getUtils(new Icontrract.IModel() {
            @Override
            public void success(ShopBean shopBean) {
                MainActivity activity = (MainActivity) v;
                activity.success(shopBean);
            }
        });
    }

    public void getShop(String id) {
        model.getCha(id, new Icontrract.ICha() {
            @Override
            public void success(ChaBean chaBean) {
                MainActivity activity = (MainActivity) v;
                activity.successa(chaBean);
            }
        });
    }
}
