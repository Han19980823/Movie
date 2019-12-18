package week1.dianshangjinjie.bw.com.yuekaob.view;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.yuekaob.R;
import week1.dianshangjinjie.bw.com.yuekaob.adapter.BottonAdapter;
import week1.dianshangjinjie.bw.com.yuekaob.adapter.Center;
import week1.dianshangjinjie.bw.com.yuekaob.adapter.LeftAdapter;
import week1.dianshangjinjie.bw.com.yuekaob.base.BaseActivity;
import week1.dianshangjinjie.bw.com.yuekaob.base.BasePresenter;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ChaBean;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ProductBean;
import week1.dianshangjinjie.bw.com.yuekaob.bean.ShopBean;
import week1.dianshangjinjie.bw.com.yuekaob.contract.Icontrract;
import week1.dianshangjinjie.bw.com.yuekaob.greendao.gen.DaoMaster;
import week1.dianshangjinjie.bw.com.yuekaob.greendao.gen.DaoSession;
import week1.dianshangjinjie.bw.com.yuekaob.greendao.gen.ProductBeanDao;
import week1.dianshangjinjie.bw.com.yuekaob.presenter.Presenter;
import week1.dianshangjinjie.bw.com.yuekaob.utils.Utils;

public class MainActivity extends BaseActivity implements Icontrract.Iview, LeftAdapter.MyCallBack, Center.Iback {


    @BindView(R.id.top_recy)
    RecyclerView topRecy;
    @BindView(R.id.center_recy)
    RecyclerView centerRecy;
    @BindView(R.id.bottom_recy)
    RecyclerView bottomRecy;
    ShopBean shopBeans;
    private Presenter presenter;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private  DaoMaster.DevOpenHelper openHelper;
    private SQLiteDatabase database;


    @Override
    protected void initData() {





    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        topRecy.setLayoutManager(manager);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        centerRecy.setLayoutManager(manager1);
        GridLayoutManager manager2 = new GridLayoutManager(this, 3);
        bottomRecy.setLayoutManager(manager2);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {

        presenter = new Presenter();
        presenter.getModel();

        return presenter;
    }

    @Override
    public void success(ShopBean shopBean) {
        shopBeans = shopBean;
        Toast.makeText(this, shopBeans.getMessage(), Toast.LENGTH_SHORT).show();
        List<ShopBean.ResultBean> result = shopBeans.getResult();
        LeftAdapter leftAdapter = new LeftAdapter(this, result);
        leftAdapter.setMyCallBack(this);
        topRecy.setAdapter(leftAdapter);
    }

    /**
     * 类别bean类
     *
     * @param chaBean
     */
    @Override
    public void successa(ChaBean chaBean) {
        List<ChaBean.ResultBean> result = chaBean.getResult();
        bottomRecy.setAdapter(new BottonAdapter(this, result));

    }

    @Override
    public void success(int i) {
        centerRecy.setVisibility(View.VISIBLE);
        List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo = shopBeans.getResult().get(i).getSecondCategoryVo();
        Center center = new Center(this, secondCategoryVo);
        center.setIback(this);
        centerRecy.setAdapter(center);

    }

    @Override
    public void getData(String id) {
        bottomRecy.setVisibility(View.VISIBLE);

        presenter.getShop(id);

    }
}
