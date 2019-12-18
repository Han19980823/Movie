package week1.dianshangjinjie.bw.com.movie.presenter;

import week1.dianshangjinjie.bw.com.movie.base.mvp.BaseFPresenter;
import week1.dianshangjinjie.bw.com.movie.bean.BannerBean;
import week1.dianshangjinjie.bw.com.movie.bean.CardBean;
import week1.dianshangjinjie.bw.com.movie.bean.HomeBean;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.model.Model;
import week1.dianshangjinjie.bw.com.movie.view.fragment.HomeFragment;

/**
 * 作者：Han98
 * 创建时间：2019/12/10
 * 描述：TODO
 * 最近修改：2019/12/10 09:09 modify by liujc
 */
public class Presenter2 extends BaseFPresenter {
    Model model;
    public Presenter2() {
        model = new Model();
    }
    public void getCard(){
        model.getCar(new Icontract.ICas() {
            @Override
            public void success(CardBean cardBean) {
                HomeFragment fragment = (HomeFragment) e;
                fragment.success(cardBean);
            }
        });
    }
}
