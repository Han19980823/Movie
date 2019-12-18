package week1.dianshangjinjie.bw.com.yuekaoa.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.yuekaoa.MyAdapter;
import week1.dianshangjinjie.bw.com.yuekaoa.MyItemAdapter;
import week1.dianshangjinjie.bw.com.yuekaoa.R;
import week1.dianshangjinjie.bw.com.yuekaoa.base.BaseActivity;
import week1.dianshangjinjie.bw.com.yuekaoa.base.BasePresenter;
import week1.dianshangjinjie.bw.com.yuekaoa.bean.CarBean;
import week1.dianshangjinjie.bw.com.yuekaoa.contract.Icontrract;
import week1.dianshangjinjie.bw.com.yuekaoa.presenter.Presenter;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity implements Icontrract.Iview  {
   @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
   @BindView(R.id.check_quan)
    CheckBox check_quan;
   @BindView(R.id.count_price)
    TextView count;
    CarBean carBeans;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter   = new Presenter();
        presenter.getModel();
        return presenter;
    }

    @Override
    public void success(CarBean carBean) {
        carBeans = carBean;
        Toast.makeText(this, carBeans.message, Toast.LENGTH_SHORT).show();
         List<CarBean.Category> result = carBeans.result;
        MyAdapter adapter = new MyAdapter(this,result);
        recyclerView.setAdapter(adapter);
        check_quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter!=null){
                    List<CarBean.Category> list = adapter.list();
                    if (list!=null  && list.size()>0){
                        //判断一级
                        for (CarBean.Category category : list) {
                            if (check_quan.isChecked()){
                                category.isChecked = true;
                            }else{
                                category.isChecked = false;
                                count.setText("0.00");
                            }
                            for (CarBean.Category.Shopping shopping : category.shoppingCartList) {
                                if (check_quan.isChecked()){
                                    shopping.isChecked = true;
                                }else{
                                    shopping.isChecked = false;
                                    count.setText("0.00");
                                }
                            }
                        }

                    }
                    adapter.notifyDataSetChanged();
                    count.setText("170.5");
                }

            }
        });

    }


}
