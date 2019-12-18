package week1.dianshangjinjie.bw.com.movie.view.fragment;

import android.view.View;

import week1.dianshangjinjie.bw.com.movie.R;
import week1.dianshangjinjie.bw.com.movie.base.mvp.BaseFPresenter;
import week1.dianshangjinjie.bw.com.movie.base.mvp.Basefragment;

/**
 * 作者：Han98
 * 创建时间：2019/12/6
 * 描述：TODO
 * 最近修改：2019/12/6 08:51 modify by liujc
 */
public class MyFragment extends Basefragment {
    @Override
    protected BaseFPresenter Ipresenter() {
        return null;
    }

    @Override
    protected int layout() {
        return R.layout.layout_my;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
