package week1.dianshangjinjie.bw.com.movie.view.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.tianmei.myapplication.greendao.gen.DaoMaster;
import com.example.tianmei.myapplication.greendao.gen.DaoSession;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import week1.dianshangjinjie.bw.com.movie.R;
import week1.dianshangjinjie.bw.com.movie.adapter.Adapter1;
import week1.dianshangjinjie.bw.com.movie.adapter.MlssAdapter;
import week1.dianshangjinjie.bw.com.movie.adapter.RxxpAdapter;
import week1.dianshangjinjie.bw.com.movie.base.mvp.BaseFPresenter;
import week1.dianshangjinjie.bw.com.movie.base.mvp.Basefragment;
import week1.dianshangjinjie.bw.com.movie.bean.CardBean;
import week1.dianshangjinjie.bw.com.movie.bean.HomeBean;
import week1.dianshangjinjie.bw.com.movie.contract.Icontract;
import week1.dianshangjinjie.bw.com.movie.presenter.Presenter;
import week1.dianshangjinjie.bw.com.movie.presenter.Presenter2;
import week1.dianshangjinjie.bw.com.movie.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/12/6
 * 描述：TODO
 * 最近修改：2019/12/6 08:51 modify by liujc
 */
public class HomeFragment extends Basefragment implements Icontract.IHomes {


    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private SQLiteDatabase database;
    RecyclerView homeCy;

    RecyclerView mlssCy;
    private CheckBox checkBox;

    @Override
    protected BaseFPresenter Ipresenter() {
        Presenter2 presenter2 = new Presenter2();
        presenter2.getCard();
        return presenter2;
    }

    @Override
    protected int layout() {
        return R.layout.layout_home;
    }

    @Override
    protected void initView(View view) {

        homeCy = view.findViewById(R.id.home_cy);
        checkBox = view.findViewById(R.id.quanxuan);


    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        homeCy.setLayoutManager(manager);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(App.context, "全选", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void success(CardBean cardBean) {
        Log.e("aaa", "success: "+cardBean.getResult() );
        List<CardBean.ResultBean> result = cardBean.getResult();
        Adapter1 adapter1 = new Adapter1(result,getContext());
        homeCy.setAdapter(adapter1);
    }
}
