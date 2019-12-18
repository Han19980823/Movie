package week1.dianshangjinjie.bw.com.demo1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo1.CarBean;
import week1.dianshangjinjie.bw.com.demo1.R;
import week1.dianshangjinjie.bw.com.demo1.adapter.FirstAdapter;
import week1.dianshangjinjie.bw.com.demo1.adapter.SeconAdapter;
import week1.dianshangjinjie.bw.com.demo1.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo1.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo1.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo1.presenter.Presenter;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity implements Icontract.Iview,FirstAdapter.dataCallBack {

    @BindView(R.id.left_recy)
    RecyclerView left_recy;
    @BindView(R.id.right_recy)
    RecyclerView right_recy;
    CarBean carBeans;
    private FirstAdapter firstAdapter;


    @Override
    protected void initData() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        left_recy.setLayoutManager(manager);
        right_recy.setLayoutManager(new StaggeredGridLayoutManager
                (3,StaggeredGridLayoutManager.VERTICAL));
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
    public void success(CarBean carBean) {
        carBeans =carBean;
        Toast.makeText(this, carBeans.getMessage(), Toast.LENGTH_SHORT).show();
        List<CarBean.ResultBean> result = carBeans.getResult();
        firstAdapter = new FirstAdapter(this,result);
        /**
         * 对象判空
         */
        if (firstAdapter!=null){
            left_recy.setAdapter(firstAdapter);
            firstAdapter.setDataCallBack(this);
        }
    }

    /**
     * 接口回调
     * @param i
     */
    @Override
    public void callBack(int i) {
        Toast.makeText(this, carBeans.getResult().get(i).getName(), Toast.LENGTH_SHORT).show();
         if (carBeans!=null){
              List<CarBean.ResultBean.SecondCategoryVoBean>  secondCategoryVo = carBeans.getResult().get(i).getSecondCategoryVo();
             SeconAdapter adapter = new SeconAdapter(this,secondCategoryVo);
             right_recy.setAdapter(adapter);
         }
    }
}
