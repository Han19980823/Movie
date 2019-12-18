package week1.dianshangjinjie.bw.com.demo3.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo3.R;
import week1.dianshangjinjie.bw.com.demo3.adapter.CarAdapter;
import week1.dianshangjinjie.bw.com.demo3.base.mvp.BaseFragment;
import week1.dianshangjinjie.bw.com.demo3.base.mvp.BasePresenter;
import week1.dianshangjinjie.bw.com.demo3.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo3.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo3.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:04 modify by liujc
 */
public class CarFragment extends BaseFragment implements Icontract.ICarFragment {
    @BindView(R.id.recy_id)
    RecyclerView recy_id;
    @BindView(R.id.quanxuan)
    CheckBox quanxuan;
    @BindView(R.id.ed_text)
    TextView editText;



    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getModel();
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.car;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_id.setLayoutManager(manager);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(CarBean carBean) {

        Toast.makeText(getContext(), carBean.getMessage(), Toast.LENGTH_SHORT).show();
        List<CarBean.ResultBean>  result = carBean.getResult();
        CarAdapter carAdapter = new CarAdapter(result, getContext());
        recy_id.setAdapter(carAdapter);

        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carAdapter.notifyDataSetChanged();
            }
        });
    }
}
