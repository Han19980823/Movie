package week1.dianshangjinjie.bw.com.demo2.adapter;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import week1.dianshangjinjie.bw.com.demo2.bean.Shop;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 14:08 modify by liujc
 */
public class Myadapter extends FragmentPagerAdapter {
    List<String> slist;
    List<Fragment> flist;

    public Myadapter(@NonNull FragmentManager fm,  List<String> slist, List<Fragment> flist) {
        super(fm);
        this.slist = slist;
        this.flist = flist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }
}
