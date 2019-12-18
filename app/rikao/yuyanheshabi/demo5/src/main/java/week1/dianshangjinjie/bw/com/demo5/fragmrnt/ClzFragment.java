package week1.dianshangjinjie.bw.com.demo5.fragmrnt;

import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo5.adapter.RogihtAdapter;
import week1.dianshangjinjie.bw.com.demo5.bean.ClzBean;
import week1.dianshangjinjie.bw.com.demo5.R;
import week1.dianshangjinjie.bw.com.demo5.adapter.CenterAdapter;
import week1.dianshangjinjie.bw.com.demo5.adapter.LeftAdapter;
import week1.dianshangjinjie.bw.com.demo5.base.BaseFragment;
import week1.dianshangjinjie.bw.com.demo5.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo5.bean.ShopBean;
import week1.dianshangjinjie.bw.com.demo5.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo5.presenter.Presentert;

/**
 * 作者：Han98
 * 创建时间：2019/11/25
 * 描述：TODO
 * 最近修改：2019/11/25 10:45 modify by liujc
 */
public class ClzFragment extends BaseFragment implements Icontract.IClzFragm, LeftAdapter.MyCallBack, CenterAdapter.IBack {
    @BindView(R.id.left_recy)
    RecyclerView leftRecy;
    @BindView(R.id.right_recy)
    RecyclerView rightRecy;
    ClzBean clzBeans;
    @BindView(R.id.center_recy)
    RecyclerView center_recy;
    private Presentert presentert;


    @Override
    protected BasePresenter Ipresenter() {
        presentert = new Presentert();
        presentert.getModel();
        return presentert;
    }

    @Override
    protected int initLayout() {
        return R.layout.clz;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        leftRecy.setLayoutManager(manager);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rightRecy.setLayoutManager(manager1);
        GridLayoutManager manager2 = new GridLayoutManager(getContext(),2);
        center_recy.setLayoutManager(manager2);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(ClzBean clzBean) {
        clzBeans = clzBean;
        Toast.makeText(getContext(), clzBeans.getMessage(), Toast.LENGTH_SHORT).show();
        List<ClzBean.ResultBean> result = clzBeans.getResult();
        LeftAdapter leftAdapter = new LeftAdapter(getContext(), result);
        if (clzBeans!=null){
            leftAdapter.setCallBack(this);
            leftRecy.setAdapter(leftAdapter);
        }

    }

    @Override
    public void success(ShopBean shopBean) {
        center_recy.setVisibility(View.VISIBLE);
        List<ShopBean.ResultBean> result = shopBean.getResult();
        RogihtAdapter RogihtAdapter =new RogihtAdapter(getContext(),result);
        center_recy.setAdapter(RogihtAdapter);

    }

    @Override
    public void back(int i) {

        rightRecy.setVisibility(View.VISIBLE);
        List<ClzBean.ResultBean.SecondCategoryVoBean> secondCategoryVo = clzBeans.getResult().get(i).getSecondCategoryVo();
         CenterAdapter adapter = new CenterAdapter(getContext(),secondCategoryVo);
         adapter.setiBack(this);
          rightRecy.setAdapter(adapter);


    }

    @Override
    public void success(String id) {
        presentert.getMode(id);
    }
}
