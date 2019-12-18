package week1.dianshangjinjie.bw.com.demo5.fragmrnt;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo5.R;
import week1.dianshangjinjie.bw.com.demo5.adapter.caradapter.CarAdapter;
import week1.dianshangjinjie.bw.com.demo5.base.BaseFragment;
import week1.dianshangjinjie.bw.com.demo5.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo5.bean.CarBean;
import week1.dianshangjinjie.bw.com.demo5.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo5.presenter.Presentert;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:46 modify by liujc
 */
public class CarFragment extends BaseFragment implements Icontract.ICarFagmen {
    @BindView(R.id.rexy_id)
    RecyclerView recyclerView;
    @BindView(R.id.quanxuan)
    CheckBox quanx;
    @Override
    protected BasePresenter Ipresenter() {
        Presentert presentert = new Presentert();
        presentert.getCar();
        return presentert;
    }

    @Override
    protected int initLayout() {
        return R.layout.car;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(CarBean carBean) {
        Toast.makeText(getContext(), carBean.getMessage(), Toast.LENGTH_SHORT).show();
        List<CarBean.ResultBean>  result = carBean.getResult();
        CarAdapter adapter = new CarAdapter(getContext(),result);
        recyclerView.setAdapter(adapter);
        quanx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adapter != null) {
                    //全选的bean类数据修改，ischeked，配合adapter的setchecked处理数据
                    List<CarBean.ResultBean> categories = adapter.getCategories();
                    if (categories != null && categories.size() > 0) {
                        //一级列表遍历
                        for (CarBean.ResultBean category : categories) {

                            if (quanx.isChecked()) {

                                category.isChecked = true;
                            } else {
                                category.isChecked = false;

                            }
                            //二级列表遍历
                            for (CarBean.ResultBean.ShoppingCartListBean shopping : category.getShoppingCartList()) {
                                if (quanx.isChecked()) {
                                    shopping.isChecked = true;
                                } else {
                                    shopping.isChecked = false;
                                }
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}
