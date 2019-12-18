package week1.dianshangjinjie.bw.com.movie.presenter;

import week1.dianshangjinjie.bw.com.movie.BannerBean;
import week1.dianshangjinjie.bw.com.movie.base.BasePresentert;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.model.Model;
import week1.dianshangjinjie.bw.com.movie.view.MainActivity;

/**
 * 作者：Han98
 * 创建时间：2019/12/2
 * 描述：TODO
 * 最近修改：2019/12/2 09:08 modify by liujc
 */
public class Presenter extends BasePresentert {
    Model model;

    public Presenter() {
         model = new Model();
    }

    public void getModel(){
        model.getUtils(new Icontract.Imodel() {
            @Override
            public void success(BannerBean bannerBean) {
                MainActivity activity = (MainActivity) v;
                activity.success(bannerBean);
            }
        });
    }
}
