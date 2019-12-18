package week1.dianshangjinjie.bw.com.demo5.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo5.R;
import week1.dianshangjinjie.bw.com.demo5.adapter.MyFragmentAdapter;
import week1.dianshangjinjie.bw.com.demo5.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo5.fragmrnt.CarFragment;
import week1.dianshangjinjie.bw.com.demo5.fragmrnt.ClzFragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_lauyout)
    TabLayout tabLayout;
    private List<String> slist = new ArrayList<>();
    private List<Fragment> flist = new ArrayList<>();

    @Override
    protected void initData() {
        slist.add("分类");
        slist.add("购物车");
        flist.add(new ClzFragment());
        flist.add(new CarFragment());
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), slist, flist);
        viewPager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }
}
