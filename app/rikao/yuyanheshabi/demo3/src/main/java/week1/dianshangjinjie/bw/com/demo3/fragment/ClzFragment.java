package week1.dianshangjinjie.bw.com.demo3.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo3.R;
import week1.dianshangjinjie.bw.com.demo3.adapter.RightAdapter;
import week1.dianshangjinjie.bw.com.demo3.base.mvp.BaseFragment;
import week1.dianshangjinjie.bw.com.demo3.base.mvp.BasePresenter;
import week1.dianshangjinjie.bw.com.demo3.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo3.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo3.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/22
 * 描述：TODO
 * 最近修改：2019/11/22 15:04 modify by liujc
 */
public class ClzFragment extends BaseFragment implements Icontract.IClz,LeftAdapter.MyCallBack {
    @BindView(R.id.left_recy)
    RecyclerView left_recy;
    @BindView(R.id.right_recy)
    RecyclerView right_recy;
    ShopBean clzBeans;
    LeftAdapter adapter;
    @Override
    protected BasePresenter Ipresenter() {


        Presenter presenter = new Presenter();
        presenter.getClzB();
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.clz;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);


        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        left_recy.setLayoutManager(manager);
        GridLayoutManager manager1 = new GridLayoutManager(getContext(),3);
        right_recy.setLayoutManager(manager1);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(ShopBean clzBean) {
        clzBeans = clzBean;
        Toast.makeText(getContext(), clzBeans.getMessage(), Toast.LENGTH_SHORT).show();
        List<ShopBean.ResultBean> result = clzBeans.getResult();
        adapter = new LeftAdapter(getContext(), result);
        if (adapter!=null){
            left_recy.setAdapter(adapter);
            /**
             * 实例化接口
             */
            adapter.setCallBack(this);
        }
    }

    /**
     * 回调回来的下标
     * @param i
     */
    @Override
    public void getNum(int i) {
        Toast.makeText(getContext(), clzBeans.getResult().get(i).getName(), Toast.LENGTH_SHORT).show();
        if (clzBeans!=null){

            List<ShopBean.ResultBean.SecondCategoryVoBean> secondCategoryVo = clzBeans.getResult().get(i).getSecondCategoryVo();
            RightAdapter rightAdapter = new RightAdapter(getContext(), secondCategoryVo);
            right_recy.setAdapter(rightAdapter);
        }

    }
}
