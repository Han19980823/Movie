package week1.dianshangjinjie.bw.com.movie.view;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.movie.MyFragmenntAdapter;
import week1.dianshangjinjie.bw.com.movie.R;
import week1.dianshangjinjie.bw.com.movie.base.BaseActivity;
import week1.dianshangjinjie.bw.com.movie.base.BasePresentert;
import week1.dianshangjinjie.bw.com.movie.view.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.movie.view.fragment.MyFragment;

public class Main3Activity extends BaseActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private List<String > slist = new ArrayList<>();
    private List<Fragment> flist = new ArrayList<>();

    @Override
    protected void initData() {
        slist.add("首页");
        slist.add("我的");
        flist.add(new HomeFragment());
        flist.add(new MyFragment());
        MyFragmenntAdapter fragmenntAdapter = new MyFragmenntAdapter(getSupportFragmentManager(),slist,flist);
        viewPager.setAdapter(fragmenntAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //预加载
        viewPager.setNextFocusForwardId(3);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main3;
    }

    @Override
    protected BasePresentert Ipresenter() {
        return null;
    }


}
