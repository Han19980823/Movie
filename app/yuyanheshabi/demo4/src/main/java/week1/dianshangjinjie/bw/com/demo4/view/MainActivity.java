package week1.dianshangjinjie.bw.com.demo4.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.adapter.MyFragmentAdapter;
import week1.dianshangjinjie.bw.com.demo4.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo4.fragment.CarFragment;
import week1.dianshangjinjie.bw.com.demo4.fragment.ClzFragment;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private List<String> slist = new ArrayList<>();
    private List<Fragment> flist = new ArrayList<>() ;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void initData() {
        slist.add("分类");
        slist.add("购物车");
        flist.add(new ClzFragment());
        flist.add(new CarFragment());
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),slist,flist);
        viewPager.setAdapter(adapter);
        tabLayout.setTabTextColors(Color.GREEN,Color.RED);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}
