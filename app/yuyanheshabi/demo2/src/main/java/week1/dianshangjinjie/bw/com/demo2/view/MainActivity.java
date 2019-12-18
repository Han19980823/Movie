package week1.dianshangjinjie.bw.com.demo2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo2.R;
import week1.dianshangjinjie.bw.com.demo2.adapter.Myadapter;
import week1.dianshangjinjie.bw.com.demo2.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo2.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo2.bean.Shop;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.fragment.OneFragmet;
import week1.dianshangjinjie.bw.com.demo2.fragment.ThreeFragment;
import week1.dianshangjinjie.bw.com.demo2.fragment.TwoFragment;
import week1.dianshangjinjie.bw.com.demo2.fragment.fourFragment;
import week1.dianshangjinjie.bw.com.demo2.fragment.wuFragment;
import week1.dianshangjinjie.bw.com.demo2.presenter.Presenter;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Icontract.Iview {
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    List<String> slist =new ArrayList<>();
    List<Fragment> flist =new ArrayList<>();

    @Override
    protected void initData() {
        slist.add("全部订单");
        slist.add("待付款");
        slist.add("待收货");
        slist.add("待评价");
        slist.add("已完成");
        flist.add(new OneFragmet());
        flist.add(new TwoFragment());
        flist.add(new ThreeFragment());
        flist.add(new fourFragment());
        flist.add(new wuFragment());
        //适配器
        Myadapter myadapter = new Myadapter(getSupportFragmentManager(),slist,flist);
        view_pager.setAdapter(myadapter);
        tab_layout.setTabTextColors(Color.GRAY,Color.rgb(140,211,236));//变颜色
        tab_layout.setupWithViewPager(view_pager);//把tablayout和viewpage绑定在一起

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getModel();
        return presenter;
    }
    @Override
    public void successs(Shop shop) {
        Toast.makeText(this, shop.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
