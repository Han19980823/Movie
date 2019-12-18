package week1.dianshangjinjie.bw.com.demo4.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo4.R;
import week1.dianshangjinjie.bw.com.demo4.adapter.OneAdapter;
import week1.dianshangjinjie.bw.com.demo4.base.mvp.BaseFragment;
import week1.dianshangjinjie.bw.com.demo4.base.mvp.BasePresenter;
import week1.dianshangjinjie.bw.com.demo4.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo4.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo4.greendao.gen.DaoMaster;
import week1.dianshangjinjie.bw.com.demo4.greendao.gen.DaoSession;
import week1.dianshangjinjie.bw.com.demo4.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/23
 * 描述：TODO
 * 最近修改：2019/11/23 09:30 modify by liujc
 */
public class CarFragment extends BaseFragment implements Icontract.ICar {
    @BindView(R.id.recy_id)
    RecyclerView recy_id;
    OneAdapter adapter;
    @BindView(R.id.num_peive)
    TextView numPeive;
    @BindView(R.id.quanxuan)
    CheckBox quanxuan;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper openHelper;

    public static CarFragment carFragment;
    private SQLiteDatabase database;

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getCar();
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.car;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_id.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        openHelper = new DaoMaster.DevOpenHelper(getContext(), "bw.db");
        database = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(database);
        carFragment = this;
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adapter != null) {
                    //全选的bean类数据修改，ischeked，配合adapter的setchecked处理数据
                    List<CarBean.Category> categories = adapter.getCategories();
                    if (categories != null && categories.size() > 0) {
                        //一级列表遍历
                        for (CarBean.Category category : categories) {

                            if (quanxuan.isChecked()) {

                                category.isChecked = true;
                            } else {
                                category.isChecked = false;

                            }
                            //二级列表遍历
                            for (CarBean.Category.Shopping shopping : category.shoppingCartList) {
                                if (quanxuan.isChecked()) {
                                    shopping.isChecked = true;
                                } else {
                                    shopping.isChecked = false;
                                }
                            }
                        }
                        adapter.notifyDataSetChanged();
                        totalPrice();
                    }
                }
            }
        });

    }

    @Override
    public void success(CarBean carBean) {
        Toast.makeText(getContext(), carBean.message, Toast.LENGTH_SHORT).show();
        List<CarBean.Category> result = carBean.result;
        adapter = new OneAdapter(getContext(), result);
        recy_id.setAdapter(adapter);
    }


    /**
     * 总价方法
     */
    public void totalPrice() {
        double total = 0;
        StringBuilder sb = new StringBuilder();

        List<CarBean.Category> categories = adapter.getCategories();
        if (categories != null && categories.size() > 0) {
            //一级列表遍历
            for (CarBean.Category category : categories) {
                //二级列表遍历
                for (CarBean.Category.Shopping shopping : category.shoppingCartList) {
                    sb.append(shopping.isChecked + "");
                    if (sb.toString().contains("true")) {
                        if (shopping.isChecked) {
                            System.out.println("price:" + shopping.price * shopping.num);
                            total += shopping.price * shopping.num;
                        }

                    } else {
                        total = 0;
                    }

                }
            }
            numPeive.setText("合计：" + String.valueOf(total));
        }

    }

}
