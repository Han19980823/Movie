package week1.dianshangjinjie.bw.com.demo3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo3.MyFragmentAdapter;
import week1.dianshangjinjie.bw.com.demo3.R;
import week1.dianshangjinjie.bw.com.demo3.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo3.fragment.CarFragment;
import week1.dianshangjinjie.bw.com.demo3.fragment.ClzFragment;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    List<String> list = new ArrayList<>();
    List<Fragment> flist = new ArrayList<>();
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;

    @Override
    protected void initData() {
        list.add("购物车");
        list.add("分类");
        flist.add(new CarFragment());
        flist.add(new ClzFragment());
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),list,flist);
        view_pager.setAdapter(adapter);
        tab_layout.setTabTextColors(Color.GREEN,Color.RED);
        tab_layout.setupWithViewPager(view_pager);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}
